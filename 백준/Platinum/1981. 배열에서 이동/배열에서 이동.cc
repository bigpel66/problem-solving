#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>

#define MAX 101
using namespace std;

int MAP[MAX][MAX];
bool visit[MAX][MAX];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
int N;

bool bfs(int min, int max)
{
    if (MAP[0][0] < min || MAP[0][0] > max)
        return false;
    queue<pair<int, int>> q;
    q.push(make_pair(0, 0));
    visit[0][0] = true;

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]
                && MAP[nx][ny] <= max && MAP[nx][ny] >= min)
            {
                q.push(make_pair(nx, ny));
                visit[nx][ny] = true;
            }
        }
    }
    return visit[N - 1][N - 1];
}

int main()
{
    int i, j, v_max, v_min;
    int left, right, res;

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> N;

    v_max = 0;
    v_min = 200;

    for (i = 0; i < N; i++)
    {
        for (j = 0; j < N; j++)
        {
            cin >> MAP[i][j];
            v_min = min(v_min, MAP[i][j]);
            v_max = max(v_max, MAP[i][j]);
        }
    }

    left = v_min;
    right = v_min;
    res = v_max;
    
    while (left <= v_max && right <= v_max) 
    {
        if (res > right - left)
        {
            memset(visit, false, sizeof(visit));
            if (!bfs(left, right))
            {
                ++right;
                continue;
            }
            res = right - left;
        }
        ++left;
    }
    
    cout << res;
    return (0);
}