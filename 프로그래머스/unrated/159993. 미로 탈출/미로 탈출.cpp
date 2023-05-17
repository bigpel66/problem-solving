#include <iostream>
#include <queue>
#include <string>
#include <tuple>
#include <vector>

using namespace std;
using point = pair<int, int>;

pair<point, point> find_char(char start, char middle, const vector<string>& maps) {
    point s, m;
    for (int i = 0 ; i < maps.size() ; i++) {
        for (int j = 0 ; j < maps.at(i).length() ; j++) {
            if (maps.at(i).at(j) == start) {
                s = point(i, j);
            }
            if (maps.at(i).at(j) == middle) {
                m = point(i, j);
            }
        }
    }
    return pair<point, point>(s, m);
}

int bfs(point p, char goal, vector<string> maps) {
    static const vector<vector<int>> displacement{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    vector<vector<bool>> is_visited(maps.size(), vector<bool>(maps.at(0).length(), false));
    queue<tuple<int, int, int>> q;
    q.push({p.first, p.second, 0});
    is_visited[p.first][p.second] = true;
    while (!q.empty()) {
        int x, y, count;
        tie(x, y, count) = q.front();
        q.pop();
        if (maps.at(x).at(y) == goal) {
            return count;
        }
        for (int i = 0 ; i < displacement.size() ; i++) {
            int next_x = x + displacement.at(i).at(0);
            int next_y = y + displacement.at(i).at(1);
            if (next_x < 0 || next_y < 0 || next_x >= maps.size() || next_y >= maps.at(0).length() || maps.at(next_x).at(next_y) == 'X' || is_visited.at(next_x).at(next_y)) {
                continue;
            }
            q.push({next_x, next_y, count + 1});
            is_visited[next_x][next_y] = true;
        }
    }
    return -1;
}

int solution(vector<string> maps) {
    pair<point, point>&& pt = find_char('S', 'L', maps);
    int dist1 = bfs(pt.first, 'L', maps);
    if (dist1 == -1)  {
        return -1;
    }
    int dist2 = bfs(pt.second, 'E', maps);
    if (dist2 == -1) {
        return -1;
    }
    return dist1 + dist2;
}