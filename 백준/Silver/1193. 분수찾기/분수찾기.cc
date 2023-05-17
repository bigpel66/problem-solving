#include <iostream>

using namespace std;
using ll = long long;

class sol {
    private:
        ll x;
        ll sum;
        ll target;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> x;
            sum = 0;
        }

        void solve(void) {
            for (int i = 1 ; ; i++) {
                sum += i;
                if (sum >= x) {
                    target = i;
                    sum -= i;
                    break;
                }
            }
            target++;
            ll diff = x - sum;
            if (!(target % 2)) {
                for (int i = target - 1 ; i >= 1 ; i--) {
                    if (!--diff) {
                        cout << i << '/' << target - i;
                        return;
                    }
                }    
            } else {
                for (int i = 1 ; i <= target - 1 ; i++) {
                    if (!--diff) {
                        cout << i << '/' << target - i;
                        return;
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

int main(void) {
    sol ve;
    return 0;
}