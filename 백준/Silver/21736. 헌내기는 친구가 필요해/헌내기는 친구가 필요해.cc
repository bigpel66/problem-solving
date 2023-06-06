#include <iostream>
#include <queue>
#include <string>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;
class sol {
private:
    int row, col;
    queue<point> q;
    vector<string> v;
    vector<vector<bool>> is_visited;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> row >> col;
        string temp;
        for (int i = 0 ; i < row ; i++) {
            cin >> temp;
            for (int j = 0 ; j < col ; j++) {
                if (temp.at(j) == 'I') {
                    q.push({i, j});
                }
            }
            v.push_back(temp);
        }
        is_visited = vector<vector<bool>>(row, vector<bool>(col, false));
        is_visited.at(q.front().first).at(q.front().second) = true;
    }

    void solve(void) {
        int count = 0;
        while (!q.empty()) {
            int cx = q.front().first;
            int cy = q.front().second;
            q.pop();
            for (size_t i = 0 ; i < displacement.size() ; i++) {
                int nx = cx + displacement.at(i).at(0);
                int ny = cy + displacement.at(i).at(1);
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }
                if (is_visited.at(nx).at(ny) || v.at(nx).at(ny) == 'X') {
                    continue;
                }
                if (v.at(nx).at(ny) == 'P') {
                    count++;
                }
                q.push({nx, ny});
                is_visited[nx][ny] = true;
            }
        }
        if (!count) {
            cout << "TT";
        } else {
            cout << count;
        }
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