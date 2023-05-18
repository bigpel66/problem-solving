#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_test;

    static const string& preset;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_test;
    }

    int exec(int index, int state) {
        if (index == 1) {
            if (!state) {
                return 9999;
            }
            return state - 1;
        } else if (index == 2) {
            int quotient = state / 1000;
            int remainder = state % 1000;
            return remainder * 10 + quotient;
        } else if (index == 3) {
            int quotient = state / 10;
            int remainder = state % 10;
            return remainder * 1000 + quotient;
        } else {
            return state * 2 % 10'000;
        }
    }

    string bfs(const int& source, const int& target) {
        queue<pair<int, string>> q;
        vector<bool> is_visited(10'000, false);
        q.push({source, ""});
        is_visited[source] = true;
        while (!q.empty()) {
            int state = q.front().first;
            string command = q.front().second;
            q.pop();
            for (size_t i = 0 ; i < preset.size() ; i++) {
                int next_state = exec(i, state);
                string next_command = command + string(1, preset.at(i));
                if (is_visited.at(next_state)) {
                    continue;
                }
                if (next_state == target) {
                    return next_command;
                }
                is_visited[next_state] = true;
                q.push({next_state, next_command});
            }
        }
        return "";
    }

    void solve(void) {
        int source, target;
        for (int i = 0 ; i < number_of_test ; i++) {
            cin >> source >> target;
            cout << bfs(source, target) << '\n';
        }
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

const string& sol::preset("DSLR");

int main(void) {
    sol ve;
    return 0;
}