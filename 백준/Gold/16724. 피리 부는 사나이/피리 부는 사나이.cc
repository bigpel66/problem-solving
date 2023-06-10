#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;
using direction = pair<int, int>;

class sol {
private:
    int row, col, answer;
    vector<string> v;

    static const unordered_map<char, direction>& move;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> row >> col;
        answer = 0;
        v = vector<string>(row, string(col, '\0'));
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                cin >> v[i][j];
            }
        }
    }

    bool is_safe_zone_required(int i, int j) {
        if (v.at(i).at(j) == 'V') {
            return true;
        }
        if (v.at(i).at(j) == 'F') {
            return false;
        }
        char direction = v.at(i).at(j);
        v[i][j] = 'V';
        bool result = is_safe_zone_required(move.at(direction).first + i, move.at(direction).second + j);
        v[i][j] = 'F';
        return result;
    }

    void solve(void) {
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                answer += is_safe_zone_required(i, j);
            }
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

const unordered_map<char, direction>& sol::move{{'U', {-1, 0}}, {'D', {1, 0}}, {'L', {0, -1}}, {'R', {0, 1}}};

int main(void) {
    sol ve;
    return 0;
}