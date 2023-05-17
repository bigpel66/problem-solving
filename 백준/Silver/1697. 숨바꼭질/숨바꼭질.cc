#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using spacetime = pair<int, int>;

class sol {
private:
    int n, k;
    queue<spacetime> q;
    vector<bool> is_visited;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> n >> k;
        q.push({0, n});
        is_visited = vector<bool>(100'001, false);
        is_visited[n] = true;
    }

    void solve(void) {
        if (n == k) {
            cout << 0;
            return;
        }
        while (!q.empty()) {
            spacetime& st = q.front();
            q.pop();
            if (st.second + 1 == k || st.second - 1 == k || st.second * 2 == k) {
                cout << st.first + 1;
                return;
            }
            if (st.second + 1 < 100'001 && !is_visited[st.second + 1]) {
                is_visited[st.second + 1] = true;
                q.push({st.first + 1, st.second + 1});
            }
            if (st.second * 2 < 100'001 && !is_visited[st.second * 2]) {
                is_visited[st.second * 2] = true;
                q.push({st.first + 1, st.second * 2});
            }
            if (st.second - 1 >= 0 && !is_visited[st.second - 1]) {
                is_visited[st.second - 1] = true;
                q.push({st.first + 1, st.second - 1});
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

int main(void) {
    sol ve;
    return 0;
}