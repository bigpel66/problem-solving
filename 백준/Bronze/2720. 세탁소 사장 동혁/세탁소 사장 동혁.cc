#include <iostream>

using namespace std;

class sol {
    private:
        int n;
        int cost;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> n;
        }
    
        int get_count_from_cost(int unit) {
            int count = 0;
            while (true) {
                if (cost < unit) {
                    break;
                }
                cost -= unit;
                count++;
            }
            return count;
        }
        
        void get_change(void) {
            int quarter, dime, nickel, penny;
            quarter = dime = nickel = penny = 0;
            cout << get_count_from_cost(25) << ' ';
            cout << get_count_from_cost(10) << ' ';
            cout << get_count_from_cost(5) << ' ';
            cout << get_count_from_cost(1) << ' ';
        }
    
        void solve(void) {
            for (int i = 0 ; i < n ; i++) {
                cin >> cost;
                get_change();
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
    sol s;
    return 0;
}