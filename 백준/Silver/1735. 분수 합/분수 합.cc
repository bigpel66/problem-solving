#include <iostream>

using namespace std;

class sol {
    private:
        int a1, b1, a2, b2;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> a1 >> b1 >> a2 >> b2;
        }
    
        int gcd(int a, int b) {
            if (!b) {
                return a;
            }
            return gcd(b, a % b);
        }
        
        void solve(void) {
            int lcm = b1 * b2 / gcd(b1, b2);
            a1 *= lcm / b1;
            a2 *= lcm / b2;
            int div = gcd(a1 + a2, lcm);
            cout << (a1 + a2) / div << ' ' << lcm / div;
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