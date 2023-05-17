#include <iostream>

using namespace std;

class sol {
    private:
        long long a, b;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> a >> b;
        }
    
        long long gcd(long long i, long long j) {
            if (j == 0) {
                return i;
            }
            return gcd(j, i % j);
        }
        
        void solve(void) {
            cout << a * b / gcd(a, b);
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