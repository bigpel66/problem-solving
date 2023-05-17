#include <cmath>
#include <iostream>

using namespace std;

class sol {
    private:
        int n;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> n;
        }
    
        void solve(void) {
            cout << static_cast<int>(pow(static_cast<int>(pow(2, n) + 1), 2));
        }
    
    public:
        sol(void) {
            stream();
            get_input();
            solve();
        }
};

int main(void) {
    sol s;
    return 0;
}