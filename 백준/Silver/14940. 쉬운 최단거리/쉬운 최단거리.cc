#include <iostream>
#include <queue>
#include <tuple>
#include <vector>

using namespace std;
using point = tuple<int, int, int>;

class sol {
private:
    int row, col;
    queue<point> q;
    vector<vector<int>> v;
    vector<vector<int>> answer;
    vector<vector<bool>> is_visited;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> row >> col;
        v = vector<vector<int>>(row, vector<int>(col, 0));
        answer = vector<vector<int>>(row, vector<int>(col, -1));
        is_visited = vector<vector<bool>>(row, vector<bool>(col, false));
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                cin >> v[i][j];
                if (v[i][j] == 2) {
                    q.push({0, i, j});
                    answer[i][j] = 0;
                    is_visited[i][j] = true;
                } else if (!v[i][j]) {
                    answer[i][j] = 0;
                }
            }
        }
    }

    void solve(void) {
        while (!q.empty()) {
            int cost, cx, cy;
            tie(cost, cx, cy) = q.front();
            q.pop();
            for (size_t i = 0 ; i < displacement.size() ; i++) {
                int nx = cx + displacement.at(i).at(0);
                int ny = cy + displacement.at(i).at(1);
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }
                if (is_visited.at(nx).at(ny) || !v.at(nx).at(ny)) {
                    continue;
                }
                q.push({cost + 1, nx, ny});
                answer[nx][ny] = cost + 1;
                is_visited[nx][ny] = true;
            }
        }
        for (auto&& i : answer) {
            for (auto&& j : i) {
                cout << j << ' ';
            }
            cout << '\n';
        }
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

const vector<vector<int>>& sol::displacement{{-1, 0}, {0, -1}, {0, 1}, {1,0}};

int main(void) {
    sol ve;
    return 0;
}