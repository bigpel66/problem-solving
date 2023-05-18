#include <iostream>
#include <queue>
#include <unordered_map>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
        private:
        int number_of_ladder;
        int number_of_snake;
        queue<point> qu;
        unordered_map<int, int> jump;
        vector<bool> is_visited;

        static const int& goal;

        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }

        void get_input(void) {
            cin >> number_of_ladder >> number_of_snake;
            int from, to;
            for (int i = 0 ; i < number_of_ladder ; i++) {
                cin >> from >> to;
                jump[from] = to;
            }
            for (int i = 0 ; i < number_of_snake ; i++) {
                cin >> from >> to;
                jump[from] = to;
            }
            qu.push({0, 1});
            is_visited = vector<bool>(101, false);
            is_visited[0] = is_visited[1] = true;
        }

    void solve(void) {
        while (!qu.empty()) {
            point cur = qu.front();
            qu.pop();
            for (int i = 1 ; i <= 6 ; i++) {
                int next = cur.second + i;
                if (next == 100) {
                    cout << cur.first + 1;
                    return;
                } else if (next > 100) {
                    continue;
                } else {
                    if (jump.find(next) != jump.end()) {
                        next = jump[next];
                    }
                    if (is_visited[next]) {
                        continue;
                    }
                    is_visited[next] = true;
                    qu.push({cur.first + 1, next});
                }
            }
        }
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

const int& sol::goal = 100;

int main(void) {
    sol ve;
    return 0;
}