#include <cmath>
#include <iostream>

using namespace std;

class sol {
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
            for (int i = 2 ; i <= sqrt(n) ; i++) {
                while (n % i == 0) {
                    cout << i << '\n';
                    n /= i;
                }
            }
            if (n > 1) {
                cout << n;
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