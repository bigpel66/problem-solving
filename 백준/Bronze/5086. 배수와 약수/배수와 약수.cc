#include <iostream>

using namespace std;

class sol {
    private:
        int a, b;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void solve(void) {
            while (true) {
                cin >> a >> b;
                if (!a && !b) {
                    return;
                }
                if (a > b && !(a % b)) {
                    cout << "multiple\n";
                } else if (a < b && !(b % a)) {
                    cout << "factor\n";
                } else {
                    cout << "neither\n";
                }
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