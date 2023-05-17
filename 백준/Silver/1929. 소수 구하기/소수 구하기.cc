#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int a, b;
        vector<bool> is_prime;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> a >> b;
            is_prime = vector<bool>(b + 1, true);
        }
    
        void generate_prime_map(void) {
            is_prime[0] = is_prime[1] = false;
            for (int i = 2 ; i <= sqrt(b) ; i++) {
                for (int j = i * 2 ; j <= b ; j += i) {
                    is_prime[j] = false;
                }
            }
        }
        
        void solve(void) {
            generate_prime_map();
            for (int i = a ; i <= b; i++) {
                if (is_prime[i]) {
                    cout << i << '\n';
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