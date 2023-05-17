#include <iostream>

using namespace std;

class sol {
    private:
        int a, b, c, d, e, f;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> a >> b >> c >> d >> e >> f;
        }
        
        void solve(void) {
            for (int i = -999 ; i <= 999 ; i++) {
                for (int j = -999 ; j <= 999 ; j++) {
                    bool first = a * i + b * j == c;
                    bool second = d * i + e * j == f;
                    if (first && second) {
                        cout << i << ' ' << j;
                        return;
                    }
                }
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