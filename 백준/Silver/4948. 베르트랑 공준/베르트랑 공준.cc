#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        vector<bool> is_prime;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            is_prime = vector<bool>(123456 * 2 + 1, true);
        }
    
        void generate_prime_map(void) {
            is_prime[0] = is_prime[1] = false;
            for (int i = 2 ; i <= sqrt(123456 * 2) ; i++) {
                for (int j = i * 2 ; j <= 123456 * 2 ; j += i) {
                    is_prime[j] = false;
                }
            }
        }
        
        void solve(void) {
            generate_prime_map();
            int n;
            while (true) {
                cin >> n;
                if (!n) {
                    break;
                }
                int count = 0;
                for (int i = n + 1 ; i <= 2 * n ; i++) {
                    if (is_prime[i]) {
                        count++;
                    }
                }
                cout << count << '\n';
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