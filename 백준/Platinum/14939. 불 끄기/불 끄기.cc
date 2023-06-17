#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int answer;
    vector<vector<bool>> light;
    vector<vector<bool>> trial;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        char signal;
        answer = INT_MAX;
        light = vector<vector<bool>>(10, vector<bool>(10, false));
        for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                cin >> signal;
                if (signal == 'O') {
                    light[i][j] = true;
                }
            }
        }
    }

    void toggle_light(int x, int y) {
        for (size_t i = 0 ; i < displacement.size() ; i++) {
            int nx = x + displacement.at(i).at(0);
            int ny = y + displacement.at(i).at(1);
            if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10) {
                continue;
            }
            trial[nx][ny] = !trial.at(nx).at(ny);
        }
        trial[x][y] = !trial.at(x).at(y);
    }

    bool is_all_light_off(void) {
        for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                if (trial.at(i).at(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    void solve(void) {
        for (int bitset = 0 ; bitset < (1 << 10) ; bitset++) {
            trial = light;
            int toggle_count = 0;
            for (int masking = 0 ; masking < 10 ; masking++) {
                if (bitset & (1 << masking)) {
                    toggle_count++;
                    toggle_light(0, masking);
                }
            }
            for (int i = 1 ; i < 10 ; i++) {
                for (int j = 0 ; j < 10 ; j++) {
                    if (trial.at(i - 1).at(j)) {
                        toggle_count++;
                        toggle_light(i, j);
                    }
                }
            }
            if (is_all_light_off()) {
                answer = min(answer, toggle_count);
            }
        }
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