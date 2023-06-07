#include <climits>
#include <iostream>
#include <vector>

using namespace std;

enum class e_direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
};

class sol {
private:
    int size, answer;
    vector<vector<int>> board;
    vector<e_direction> direction;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> size;
        answer = 0;
        board = vector<vector<int>>(size, vector<int>(size, 0));
        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                cin >> board[i][j];
            }
        }
    }

    int get_max(const vector<vector<int>>& v) {
        int value = INT_MIN;
        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                value = max(value, v.at(i).at(j));
            }
        }
        return value;
    }

    void shift_up(vector<vector<int>>& v) {
        for (int row = 0 ; row < size - 1 ; row++) {
            for (int col = 0 ; col < size ; col++) {
                if (v.at(row).at(col)) {
                    continue;
                }
                int comp_row = row + 1;
                while (comp_row < size) {
                    if (v.at(comp_row).at(col)) {
                        break;
                    }
                    comp_row++;
                }
                if (comp_row < size) {
                    v[row][col] = v.at(comp_row).at(col);
                    v[comp_row][col] = 0;
                }
            }
        }
    }

    void sum_up(vector<vector<int>>& v) {
        shift_up(v);
        for (int row = 0 ; row < size - 1 ; row++) {
            for (int col = 0 ; col < size ; col++) {
                if (v.at(row).at(col) == v.at(row + 1).at(col)) {
                    v[row][col] *= 2;
                    v[row + 1][col] = 0;
                }
            }
        }
        shift_up(v);
    }

    void shift_down(vector<vector<int>>& v) {
        for (int row = size - 1 ; row > 0 ; row--) {
            for (int col = 0 ; col < size ; col++) {
                if (v.at(row).at(col)) {
                    continue;
                }
                int comp_row = row - 1;
                while (comp_row >= 0) {
                    if (v.at(comp_row).at(col)) {
                        break;
                    }
                    comp_row--;
                }
                if (comp_row >= 0) {
                    v[row][col] = v.at(comp_row).at(col);
                    v[comp_row][col] = 0;
                }
            }
        }
    }

    void sum_down(vector<vector<int>>& v) {
        shift_down(v);
        for (int row = size - 1 ; row > 0 ; row--) {
            for (int col = 0 ; col < size ; col++) {
                if (v.at(row).at(col) == v.at(row - 1).at(col)) {
                    v[row][col] *= 2;
                    v[row - 1][col] = 0;
                }
            }
        }
        shift_down(v);
    }

    void shift_left(vector<vector<int>>& v) {
        for (int row = 0 ; row < size ; row++) {
            for (int col = 0 ; col < size - 1 ; col++) {
                if (v.at(row).at(col)) {
                    continue;
                }
                int comp_col = col + 1;
                while (comp_col < size) {
                    if (v.at(row).at(comp_col)) {
                        break;
                    }
                    comp_col++;
                }
                if (comp_col < size) {
                    v[row][col] = v.at(row).at(comp_col);
                    v[row][comp_col] = 0;
                }
            }
        }
    }

    void sum_left(vector<vector<int>>& v) {
        shift_left(v);
        for (int row = 0 ; row < size ; row++) {
            for (int col = 0 ; col < size - 1 ; col++) {
                if (v.at(row).at(col) == v.at(row).at(col + 1)) {
                    v[row][col] *= 2;
                    v[row][col + 1] = 0;
                }
            }
        }
        shift_left(v);
    }

    void shift_right(vector<vector<int>>& v) {
        for (int row = 0 ; row < size ; row++) {
            for (int col = size - 1 ; col > 0 ; col--) {
                if (v.at(row).at(col)) {
                    continue;
                }
                int comp_col = col - 1;
                while (comp_col >= 0) {
                    if (v.at(row).at(comp_col)) {
                        break;
                    }
                    comp_col--;
                }
                if (comp_col >= 0) {
                    v[row][col] = v.at(row).at(comp_col);
                    v[row][comp_col] = 0;
                }
            }
        }
    }

    void sum_right(vector<vector<int>>& v) {
        shift_right(v);
        for (int row = 0 ; row < size ; row++) {
            for (int col = size - 1 ; col > 0 ; col--) {
                if (v.at(row).at(col) == v.at(row).at(col - 1)) {
                    v[row][col] *= 2;
                    v[row][col - 1] = 0;
                }
            }
        }
        shift_right(v);
    }

    vector<vector<int>> play_2048(vector<vector<int>> v) {
        for (int i = 0 ; i < 5 ; i++) {
            switch (direction.at(i)) {
                case e_direction::UP:
                    sum_up(v);
                    break;
                case e_direction::DOWN:
                    sum_down(v);
                    break;
                case e_direction::LEFT:
                    sum_left(v);
                    break;
                case e_direction::RIGHT:
                    sum_right(v);
                    break;
            }
        }
        return v;
    }

    void dfs(int count) {
        if (count == 5) {
            vector<vector<int>>&& result = play_2048(board);
            answer = max(answer, get_max(result));
            return;
        }
        for (int i = 0 ; i < 4 ; i++) {
            direction.push_back(static_cast<e_direction>(i));
            dfs(count + 1);
            direction.pop_back();
        }
    }

    void solve(void) {
        dfs(0);
        cout << answer;
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

int main(void) {
    sol ve;
    return 0;
}