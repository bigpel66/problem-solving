#include <climits>
#include <cmath>
#include <iostream>

using namespace std;

class sol {
    private:
        int n;
        int x, y;
        int min_x, max_x, min_y, max_y;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
            min_x = min_y = INT_MAX;
            max_x = max_y = INT_MIN;
        }
        
        void solve(void) {
            for (int i = 0 ; i < n ; i++) {
                cin >> x >> y;
                min_x = min(x, min_x);
                min_y = min(y, min_y);
                max_x = max(x, max_x);
                max_y = max(y, max_y);
            }
            cout << (max_x - min_x) * (max_y - min_y);
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