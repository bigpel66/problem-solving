#include <algorithm>
#include <cmath>
#include <iostream>

using namespace std;

class sol {
    private:
        int n;
        vector<int> factors;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void print_factors_with_operators(void) {
            cout << " = " << factors.at(0);
            for (size_t i = 1 ; i < factors.size() ; i++) {
                cout << " + " << factors.at(i);
            }
            cout << '\n';
        }
    
        void print_result_string(bool is_perfect) {
            cout << n;
            if (is_perfect) {
                print_factors_with_operators();
            } else {
                cout << " is NOT perfect.\n";
            }
        }
    
        int sum_of_factors() {
            int acc = 0;
            for (int i = 1 ; i <= sqrt(n) ; i++) {
                if (!(n % i)) {
                    acc += i;
                    factors.push_back(i);
                    if (i != n / i && n / i != n) {
                        acc += n / i;
                        factors.push_back(n / i);
                    }
                }
            }
            sort(factors.begin(), factors.end(), less<int>());
            return acc;
        }
    
        void solve(void) {
            while (true) {
                cin >> n;
                if (n == -1) {
                    return;
                }
                print_result_string(n == sum_of_factors());
                factors.clear();
            }
        }
    
    public:
        sol(void) {
            stream();
            solve();
        }
};

int main(void) {
    sol ve;
    return 0;
}