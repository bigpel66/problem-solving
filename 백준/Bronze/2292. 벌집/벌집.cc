#include <iostream>

using namespace std;
using ll = long long;

class sol {
    private:
        ll n;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> n;
        }
    
        void solve(void) {
            ll i = 1;
            ll step = 0;
            while (true) {
                if (n <= i) {
                    break;
                }
                i += (++step * 6);
            }
            cout << step + 1;
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