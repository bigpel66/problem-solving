#include <iostream>
#include <string>

using namespace std;

class t_sol {
    private:
        int n;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> n;
        }
    
        void solve(void) {
            for (int i = 0 ; i < n - 1 ; i++) {
                cout << string(n - (i + 1), ' ') << string(2 * i + 1, '*') << '\n';
            }
            cout << string(2 * (n - 1) + 1, '*') << '\n';
            for (int i = 0 ; i < n - 1; i++) {
                cout << string(i + 1, ' ') << string(2 * (n - (i + 1) - 1) + 1, '*') << '\n';
            }
        }
    
    public:
        t_sol(void) {
            stream();
            get_input();
            solve();
        }
};

int main(void) {
    t_sol s;
    return 0;
}