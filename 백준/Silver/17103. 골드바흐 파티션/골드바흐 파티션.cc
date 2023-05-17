#include <cmath>
#include <iostream>
#include <set>
#include <vector>

using namespace std;

class sol {
    private:
        int n;
        vector<bool> is_prime;
        set<int> prime_factor;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
            is_prime = vector<bool>(1'000'001, true);
        }
    
        void generate_prime_map(void) {
            for (int i = 0 ; i <= 1'000'000 ; i += 2) {
                is_prime[i] = false;
            }
            is_prime[2] = true;
            for (int i = 3 ; i <= 1'000'000 ; i += 2) {
                if (is_prime[i]) {
                    for (int j = i * 3 ; j <= 1'000'000 ; j += i * 2) {
                        is_prime[j] = false;
                    }
                }
            }
            for (int i = 2 ; i <= 1'000'000 ; i++) {
                if (is_prime[i]) {
                    prime_factor.insert(i);
                }
            }
        }
        
        void solve(void) {
            generate_prime_map();
            int temp;
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                int count = 0;
                for (auto&& j : prime_factor) {
                    if (j > temp / 2) {
                        break;
                    }
                    if (prime_factor.find(temp - j) != prime_factor.end()) {
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