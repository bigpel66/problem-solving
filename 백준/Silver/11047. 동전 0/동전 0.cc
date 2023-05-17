#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int number_of_coin;
        int target;
        int count;
        vector<int> v;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> number_of_coin >> target;
            count = 0;
            v = vector<int>(number_of_coin, 0);
            for (auto&& i : v) {
                cin >> i;
            }
        }
        
        void solve(void) {
            for (auto&& iter = v.rbegin() ; iter != v.rend() ; iter++) {
                int temp = (target / *iter);
                target -= *iter * temp;
                count += temp;
                if (!target) {
                    break;
                }
            }
            cout << count;
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