#include <climits>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int begin, end;
        int min_val, acc;
        vector<bool> is_prime;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> begin >> end;
            min_val = INT_MAX;
            acc = 0;
            is_prime = vector<bool>(end + 1, true);
        }
    
        void generate_prime_map(void) {
            is_prime[0] = is_prime[1] = false;
            for (int i = 2 ; i <= sqrt(end) ; i++) {
                for (int j = i * 2 ; j <= end ; j += i) {
                    is_prime[j] = false;
                }
            }
        }
    
        void solve(void) {
            generate_prime_map();
            for (int i = begin ; i <= end ; i++) {
                if (is_prime.at(i)) {
                    min_val = min(min_val, i);
                    acc += i;
                }
            }
            if (min_val == INT_MAX) {
                cout << -1;
            } else {
                cout << acc << '\n' << min_val;                
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