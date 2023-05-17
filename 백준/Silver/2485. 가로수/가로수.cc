#include <algorithm>
#include <iostream>
#include <numeric>
#include <vector>

using namespace std;

class sol {
    private:
        int n;
        vector<long long> vec;
        vector<long long> diff;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
            long long temp;
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                vec.push_back(temp);
            }
            diff.resize(vec.size());
            sort(vec.begin(), vec.end(), less<int>());
            adjacent_difference(vec.begin(), vec.end(), diff.begin());
            diff.erase(diff.begin());
        }
        
        int gcd(int a, int b) {
            if (!b) {
                return a;
            }
            return gcd(b, a % b);
        }
        
        void solve(void) {
            int init = diff.at(0);
            for (auto&& i : diff) {
                init = gcd(init, i);
            }
            int acc = 0;
            for (auto&& i : diff) {
                acc += i / init - 1;
            }
            cout << acc;
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