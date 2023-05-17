#include <climits>
#include <cmath>
#include <iostream>
#include <utility>

using namespace std;
using point = pair<int, int>;

class t_sol {
    private:
        int max;
        int temp;
        point p;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            max = INT_MIN;
        }
    
        void solve(void) {
            for (int i = 1 ; i <= 9 ; i++) {
                for (int j = 1 ; j <= 9 ; j++) {
                    cin >> temp;
                    if (temp > max) {
                        max = temp;
                        p = point(i, j);
                    }
                }
            }
            cout << max << '\n' << p.first << ' ' << p.second;
        }
    
    public:
        t_sol(void) {
            stream();
            get_input();
            solve();
        }
};

int main(void) {
    t_sol s;
    return 0;
}