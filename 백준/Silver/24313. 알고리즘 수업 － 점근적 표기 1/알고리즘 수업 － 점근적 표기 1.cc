#include <iostream>

using namespace std;

class sol {
    private:
        int a1, a0;
        int c;
        int n0;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> a1 >> a0 >> c >> n0;
        }
        
        void solve(void) {
            for (int i = n0 ; i <= 100 ; i++) {
                int fn0 = a1 * i + a0;
                int gn0 = c * i;
                if (fn0 > gn0) {
                    cout << 0;
                    return;
                }
            }
            cout << 1;
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