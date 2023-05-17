#include <cmath>
#include <iostream>

using namespace std;

class sol {
    private:
        long long n;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
        }
    
        bool is_prime(long long temp) {
            if (temp == 0 || temp == 1) {
                return false;
            }
            for (long long i = 2 ; i <= sqrt(temp) ; i++) {
                if (temp % i == 0) {
                    return false;
                }
            }
            return true;
        }
        
        void solve(void) {
            long long temp;
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                while (!is_prime(temp)) {
                    temp++;
                }
                cout << temp << '\n';
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