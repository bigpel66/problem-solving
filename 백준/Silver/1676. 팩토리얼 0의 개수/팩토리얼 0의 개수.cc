#include <cmath>
#include <iostream>

using namespace std;

class sol {
    private:
        int count_2;
        int count_5;
        int n;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
            count_2 = count_5 = 0;
        }
        
        void solve(void) {
            for (int i = n ; i >= 2 ; i--) {
                int temp = i;
                while (!(temp % 2)) {
                    count_2++;
                    temp /= 2;
                }
                temp = i;
                while (!(temp % 5)) {
                    count_5++;
                    temp /= 5;
                }
            }
            cout << min(count_2, count_5);
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