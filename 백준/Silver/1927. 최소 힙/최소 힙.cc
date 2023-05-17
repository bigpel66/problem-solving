#include <iostream>
#include <queue>

using namespace std;

class sol {
    private:
        int n;
        priority_queue<int> q;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
        }
        
        void solve(void) {
            int temp;
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                if (!temp) {
                    if (q.empty()) {
                        cout << 0 << '\n';
                    } else {
                        cout << -q.top() << '\n';
                        q.pop();
                    }
                } else {
                    q.push(-temp);
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