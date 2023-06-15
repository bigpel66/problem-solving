#include <algorithm>
#include <climits>
#include <cmath>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
private:
    size_t size, temp, answer;
    vector<point> white;
    vector<point> black;
    vector<point> rooted;
    vector<vector<int>> bishop;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> size;
        answer = 0;
        bishop = vector<vector<int>>(size, vector<int>(size, 0));
        for (size_t i = 0 ; i < size ; i++) {
            for (size_t j = 0 ; j < size ; j++) {
                cin >> bishop[i][j];
                if (!bishop.at(i).at(j)) {
                    continue;
                }
                if ((i + j) % 2) {
                    black.push_back({i, j});
                } else {
                    white.push_back({i, j});
                }
            }
        }
    }

    bool is_placeable(const point& current) {
        for (size_t i = 0 ; i < rooted.size() ; i++) {
            const point& placed = rooted.at(i);
            if (abs(current.first - placed.first) == abs(current.second - placed.second)) {
                return false;
            }
        }
        return true;
    }

    void dfs(int index, const vector<point>& chess) {
        temp = max(temp, rooted.size());
        if (index == chess.size()) {
            return;
        }
        if (is_placeable(chess.at(index))) {
            rooted.push_back(chess.at(index));
            dfs(index + 1, chess);
            rooted.pop_back();
        }
        dfs(index + 1, chess);
    }

    void solve(void) {
        temp = 0;
        dfs(0, white);
        answer += temp;
        temp = 0;
        dfs(0, black);
        answer += temp;
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