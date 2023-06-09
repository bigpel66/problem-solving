#include <cctype>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
private:
    int number_of_test;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_test;
    }

    void bfs(int x, int y, int row, int col, int& answer, vector<string>& v, vector<bool>& key, vector<vector<bool>>& is_visited) {
        queue<point> q;
        vector<queue<point>> door(26);
        q.push({x, y});
        is_visited[x][y] = true;
        while (!q.empty()) {
            int cx = q.front().first;
            int cy = q.front().second;
            q.pop();
            for (size_t i = 0 ; i < displacement.size() ; i++) {
                int nx = cx + displacement.at(i).at(0);
                int ny = cy + displacement.at(i).at(1);
                if (nx < 0 || ny < 0 || nx > row + 1 || ny > col + 1 || is_visited.at(nx).at(ny) || v.at(nx).at(ny) == '*') {
                    continue;
                }
                if (isupper(v.at(nx).at(ny))) {
                    if (key.at(v.at(nx).at(ny) - 'A')) {
                        q.push({nx, ny});
                    } else {
                        door[v.at(nx).at(ny) - 'A'].push({nx, ny});
                    }
                } else if (islower(v.at(nx).at(ny))) {
                    q.push({nx, ny});
                    if (!key.at(v.at(nx).at(ny) - 'a')) {
                        key[v.at(nx).at(ny) - 'a'] = true;
                        while (!door.at(v.at(nx).at(ny) - 'a').empty()) {
                            point p = door.at(v.at(nx).at(ny) - 'a').front();
                            q.push({p.first, p.second});
                            door.at(v.at(nx).at(ny) - 'a').pop();
                        }
                    }
                } else {
                    if (v.at(nx).at(ny) == '$') {
                        answer++;
                    }
                    q.push({nx, ny});
                }
                is_visited[nx][ny] = true;
            }
        }
    }

    void solve(void) {
        int row, col, answer;
        string temp;
        vector<string> v;
        vector<bool> key;
        vector<vector<bool>> is_visited;
        cin >> row >> col;
        answer = 0;
        v = vector<string>(row + 2, string(col + 2, '.'));
        is_visited = vector<vector<bool>>(row + 2, vector<bool>(col + 2, false));
        key = vector<bool>(26, false);
        for (int i = 1;  i <= row ; i++) {
            for (int j = 1 ; j <= col ; j++) {
                cin >> v[i][j];
            }
        }
        cin >> temp;
        if (temp != "0") {
            for (size_t i = 0 ; i < temp.length() ; i++) {
                key[temp.at(i) - 'a'] = true;
            }
        }
        bfs(0, 0, row, col, answer, v, key, is_visited);
        cout << answer << '\n';
    }

public:
    sol(void) {
        stream();
        get_input();
        while (number_of_test--) {
            solve();
        }
    }
};

const vector<vector<int>>& sol::displacement{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

int main(void) {
    sol ve;
    return 0;
}