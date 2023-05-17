#include <cmath>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;
using expect = pair<int, point>;

class sol {
private:
    int row, col, answer;
    vector<vector<int>> v;
    queue<expect> q;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> col >> row;
        answer = 0;
        v = vector<vector<int>>(row, vector<int>(col, 0));
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                cin >> v[i][j];
                if (v[i][j] == 1) {
                    q.push({0, {i, j}});
                }
            }
        }
    }

    bool is_all_rotten(void) {
        for (auto&& i : v) {
            for (auto&& j : i) {
                if (!j) {
                    return false;
                }
            }
        }
        return true;
    }

    void bfs(void) {
        while (!q.empty()) {
            expect e = q.front();
            q.pop();
            int day = e.first;
            point p = e.second;
            for (size_t i = 0 ; i < displacement.size() ; i++) {
                int next_x = p.first + displacement.at(i).at(0);
                int next_y = p.second + displacement.at(i).at(1);
                if (next_x < 0 || next_y < 0
                    || next_x >= row || next_y >= col
                    || v[next_x][next_y] != 0) {
                    continue;
                }
                q.push({day + 1, {next_x, next_y}});
                answer = max(answer, day + 1);
                v[next_x][next_y] = 1;
            }
        }
    }

    void solve(void) {
        bfs();
        if (is_all_rotten()) {
            cout << answer;
        } else{
            cout << -1;
        };
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