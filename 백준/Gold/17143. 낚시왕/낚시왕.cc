#include <algorithm>
#include <iostream>

using namespace std;

class shark {
public:
    int i;
    int cx;
    int cy;
    int dir;
    int size;
    int speed;
    bool is_alive;
};

class sol {
private:
    int row, col, number_of_shark, answer;
    vector<shark> v;
    vector<vector<vector<int>>> map;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> row >> col >> number_of_shark;
        answer = 0;
        v = vector<shark>(number_of_shark);
        map = vector<vector<vector<int>>>(row + 1, vector<vector<int>>(col + 1));
        for (int i = 0 ; i < number_of_shark ; i++) {
            v[i].i = i;
            cin >> v[i].cx >> v[i].cy >> v[i].speed >> v[i].dir >> v[i].size;
            v[i].is_alive = true;
            map[v.at(i).cx][v.at(i).cy].push_back(i);
        }
    }

    bool is_shark_all_dead(void) {
        for (auto&& i : v) {
            if (i.is_alive) {
                return false;
            }
        }
        return true;
    }

    void fish_on_map(int area) {
        for (int i = 1 ; i <= row ; i++) {
            if (!map.at(i).at(area).size()) {
                continue;
            }
            int shark_index = map.at(i).at(area).at(0);
            shark& s = v.at(shark_index);
            answer += s.size;
            s.is_alive = false;
            map[i][area].clear();
            break;
        }
    }

    void reset_alive_on_map(void) {
        for (size_t i = 0 ; i < v.size() ; i++) {
            if (!v.at(i).is_alive) {
                continue;
            }
            map[v.at(i).cx][v.at(i).cy].clear();
        }
    }

    void move_row(int& cx, int& dir, int& speed) {
        speed %= (row - 1) * 2;
        for (int j = 0 ; j < speed ; j++) {
            int nx = cx + displacement.at(dir).at(0);
            if (nx < 1) {
                dir = 2;
                nx += 2;
            }
            if (nx > row) {
                dir = 1;
                nx -= 2;
            }
            cx = nx;
        }
    }

    void move_col(int& cy, int& dir, int& speed) {
        speed %= (col - 1) * 2;
        for (int j = 0 ; j < speed; j++) {
            int ny = cy + displacement.at(dir).at(1);
            if (ny < 1) {
                dir = 3;
                ny += 2;
            }
            if (ny > col) {
                dir = 4;
                ny -= 2;
            }
            cy = ny;
        }
    }

    void stroll_on_map(void) {
        for (size_t i = 0 ; i < v.size() ; i++) {
            if (!v.at(i).is_alive) {
                continue;
            }
            int cx = v.at(i).cx;
            int cy = v.at(i).cy;
            int dir = v.at(i).dir;
            int speed = v.at(i).speed;
            if (v.at(i).dir == 1 || v.at(i).dir == 2) {
                move_row(cx, dir, speed);
            } else {
                move_col(cy, dir, speed);
            }
            v[i].cx = cx;
            v[i].cy = cy;
            v[i].dir = dir;
            map[cx][cy].push_back(i);
        }
    }

    void kill_on_map(void) {
        for (int i = 1 ; i <= row ; i++) {
            for (int j = 1 ; j <= col ; j++) {
                if (map.at(i).at(j).size() < 2) {
                    continue;
                }
                sort(map[i][j].begin(), map[i][j].end(), [&](auto&& i, auto&& j) -> bool {
                    return v.at(i).size > v.at(j).size;
                });
                int biggest_index = map.at(i).at(j).at(0);
                for (size_t k = 1 ; k < map.at(i).at(j).size() ; k++) {
                    int index = map.at(i).at(j).at(k);
                    v[index].is_alive = false;
                }
                map[i][j].clear();
                map[i][j].push_back(biggest_index);
            }
        }
    }

    void solve(void) {
        if (!number_of_shark) {
            cout << answer;
            return;
        }
        for (int i = 1 ; i <= col ; i++) {
            if (is_shark_all_dead()) {
                break;
            }
            fish_on_map(i);
            reset_alive_on_map();
            stroll_on_map();
            kill_on_map();
        }
        cout << answer;
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

const vector<vector<int>>& sol::displacement{{0, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};

int main(void) {
    sol ve;
    return 0;
}