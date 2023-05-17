#include <iostream>

using namespace std;

class sol {
    private:
        int x1, x2, x3, x4, y1, y2, y3, y4;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;
        }
        
        void solve(void) {
            if (x1 == x2) {
                x4 = x3;
            } else if (x1 == x3) {
                x4 = x2;
            } else {
                x4 = x1;
            }
            if (y1 == y2) {
                y4 = y3;
            } else if (y1 == y3) {
                y4 = y2;
            } else {
                y4 = y1;
            }
            cout << x4 << ' ' << y4;
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