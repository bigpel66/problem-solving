#include <climits>
#include <iostream>
#include <queue>
#include <string>
#include <tuple>
#include <vector>

using namespace std;
using point = tuple<int, int, int, bool>;

class sol {
private:
    int row, col, answer;
    vector<string> v;
    vector<vector<vector<bool>>> is_visited;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> row >> col;
        answer = INT_MAX;
        v = vector<string>(row);
        for (int i = 0 ; i < row ; i++) {
            cin >> v[i];
        }
        is_visited = vector<vector<vector<bool>>>(row, vector<vector<bool>>(col, vector<bool>(2, false)));
    }

    bool is_next_is_1_and_never_been_at_1(bool is_crash_used, int nx, int ny) {
        return v.at(nx).at(ny) == '1' && !is_crash_used;
    }

    bool is_current_is_0_and_not_visited_regardless_of_crashed(bool is_crashed, int nx, int ny) {
        return v.at(nx).at(ny) == '0' && !is_visited.at(nx).at(ny).at(is_crashed);
    }

    void bfs(void) {
        queue<point> q;
        q.push({0, 0, 1, false});
        is_visited[0][0][false] = true;
        while (!q.empty()) {
            point cur = q.front();
            int cx, cy, cost, is_crash_used;
            tie(cx, cy, cost, is_crash_used) = cur;
            q.pop();
            for (int i = 0 ; i < displacement.size() ; i++) {
                int nx = cx + displacement.at(i).at(0);
                int ny = cy + displacement.at(i).at(1);
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }
                if (nx == row - 1 && ny == col - 1) {
                    answer = cost + 1;
                    return;
                }
                if (is_next_is_1_and_never_been_at_1(is_crash_used, nx, ny)) {
                    q.push({nx, ny, cost + 1, true});
                    is_visited[nx][ny][true] = true;
                } else if (is_current_is_0_and_not_visited_regardless_of_crashed(is_crash_used, nx, ny)) {
                    q.push({nx, ny, cost + 1, is_crash_used});
                    is_visited[nx][ny][is_crash_used] = true;
                }
            }
        }
    }

    void solve(void) {
        if (row == 1 && col == 1) {
            cout << 1;
            return;
        }
        bfs();
        cout << (answer == INT_MAX ? -1 : answer);
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

const vector<vector<int>>& sol::displacement{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

int main(void) {
    sol ve;
    return 0;
}