#include <algorithm>
#include <climits>
#include <cmath>
#include <iostream>
#include <string>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
private:
    int row, col, answer;
    vector<string> v;
    point red, blue;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> row >> col;
        answer = INT_MAX;
        v = vector<string>(row, string(col, '\0'));
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                cin >> v[i][j];
                if (v.at(i).at(j) == 'R') {
                    red.first = i;
                    red.second = j;
                    v[i][j] = '.';
                } else if (v.at(i).at(j) == 'B') {
                    blue.first = i;
                    blue.second = j;
                    v[i][j] = '.';
                }
            }
        }
    }

    bool roll_marvel(int dx, int dy, point& moved_p) {
        int nx = moved_p.first + dx;
        int ny = moved_p.second + dy;
        while (true) {
            if (v.at(nx).at(ny) == '#' || v.at(nx).at(ny) == 'O') {
                break;
            }
            nx += dx;
            ny += dy;
        }
        moved_p.first = nx - dx;
        moved_p.second = ny - dy;
        if (v.at(nx).at(ny) == 'O') {
            return true;
        }
        return false;
    }

    int get_moved_distance(const point& p, const point& moved_p) {
        return abs(p.first - moved_p.first) + abs(p.second - moved_p.second);
    }

    void adjust_overlapped_marvel(int dx, int dy, const point& r, const point& b, point& moved_r, point& moved_b) {
        if (moved_r.first != moved_b.first || moved_r.second != moved_b.second) {
            return;
        }
        int r_dist = get_moved_distance(r, moved_r);
        int b_dist = get_moved_distance(b, moved_b);
        if (r_dist > b_dist) {
            moved_r.first -= dx;
            moved_r.second -= dy;
        } else {
            moved_b.first -= dx;
            moved_b.second -= dy;
        }
    }

    void dfs(const point r, const point b, int count, size_t direction) {
        if (count > 10 || count >= answer) {
            return;
        }
        int dx = displacement.at(direction).at(0);
        int dy = displacement.at(direction).at(1);
        point moved_r = r;
        point moved_b = b;
        bool is_red_exited = roll_marvel(dx, dy, moved_r);
        bool is_blue_exited = roll_marvel(dx, dy, moved_b);
        if (is_blue_exited) {
            return;
        }
        if (is_red_exited) {
            answer = min(answer, count);
            return;
        }
        adjust_overlapped_marvel(dx, dy, r, b, moved_r, moved_b);
        for (size_t i = 0 ; i < displacement.size() ; i++) {
            if (i == direction) {
                continue;
            }
            dfs(moved_r, moved_b, count + 1, i);
        }
    }

    void solve(void) {
        for (size_t i = 0 ;  i < displacement.size() ; i++) {
            dfs(red, blue, 1, i);
        }
        if (answer > 10 || answer == INT_MAX) {
            cout << -1;
        } else {
            cout << answer;
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