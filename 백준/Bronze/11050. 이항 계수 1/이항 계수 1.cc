#include <iostream>

using namespace std;

class sol {
    private:
        int n, k;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n >> k;
        }
    
        int comb(int x, int y) {
            if (y == 0 || x == y) {
                return 1;
            }
            return comb(x - 1, y) + comb(x - 1, y - 1);
        }
        
        void solve(void) {
            cout << comb(n, n / 2 < k ? n - k : k);
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