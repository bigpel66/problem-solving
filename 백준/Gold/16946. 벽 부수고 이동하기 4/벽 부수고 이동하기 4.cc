#include <iostream>
#include <queue>
#include <string>
#include <unordered_set>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
private:
    int row, col;
    int area_id;
    vector<string> v;
    vector<size_t> size;
    vector<vector<int>> area;
    vector<vector<bool>> is_visited;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> row >> col;
        area_id = 0;
        v = vector<string>(row, string(col, '\n'));
        area = vector<vector<int>>(row, vector<int>(col, -1));
        is_visited = vector<vector<bool>>(row, vector<bool>(col, false));
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                cin >> v[i][j];
            }
        }
    }

    void bfs(int i, int j) {
        queue<point> q;
        q.push({i, j});
        is_visited[i][j] = true;
        area[i][j] = area_id;
        size_t count = 1;
        while (!q.empty()) {
            int cx = q.front().first;
            int cy = q.front().second;
            q.pop();
            for (size_t i = 0 ; i < displacement.size() ; i++) {
                int nx = cx + displacement.at(i).at(0);
                int ny = cy + displacement.at(i).at(1);
                if (nx < 0 || ny < 0 || nx >= row || ny >= col || is_visited.at(nx).at(ny) || v.at(nx).at(ny) == '1') {
                    continue;
                }
                q.push({nx, ny});
                is_visited[nx][ny] = true;
                area[nx][ny] = area_id;
                count++;
            }
        }
        size.push_back(count);
        area_id++;
    }

    void grant_area_id(void) {
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (v.at(i).at(j) == '1' || is_visited.at(i).at(j)) {
                    continue;
                }
                bfs(i, j);
            }
        }
    }

    void find_available_path(void) {
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (v.at(i).at(j) == '0') {
                    continue;
                }
                unordered_set<int> is_area_visited;
                for (size_t k = 0 ; k < displacement.size() ; k++) {
                    int nx = i + displacement.at(k).at(0);
                    int ny = j + displacement.at(k).at(1);
                    if (nx < 0 || ny < 0 || nx >= row || ny >= col || area.at(nx).at(ny) == -1) {
                        continue;
                    }
                    if (is_area_visited.find(area.at(nx).at(ny)) != is_area_visited.end()) {
                        continue;
                    }
                    int count = v.at(i).at(j) - '0';
                    count += size.at(area.at(nx).at(ny));
                    count %= 10;
                    count += '0';
                    v[i][j] = count;
                    is_area_visited.insert(area.at(nx).at(ny));
                }
            }
        }
    }

    void solve(void) {
        grant_area_id();
        find_available_path();
        for (auto&& i : v) {
            for (auto&& j : i) {
                cout << j;
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

const vector<vector<int>>& sol::displacement{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

int main(void) {
    sol ve;
    return 0;
}