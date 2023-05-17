#include <iostream>
#include <string>

using namespace std;
using ll = long long;

class t_solution {
    private:
        int number_of_item;
        ll price_on_receipt;
        ll price_accumulated;
    
        string boolean_to_string(bool boolean) {
            return boolean ? "Yes" : "No";
        }
    
        void get_input(void) {
            price_accumulated = 0;
            cin >> price_on_receipt >> number_of_item;
            for (int i = 0 ; i < number_of_item ; i++) {
                int price, count;
                cin >> price >> count;
                price_accumulated += static_cast<ll>(price) * count;
            }
        }
    
        void solve(void) {
            cout << boolean_to_string(price_on_receipt == price_accumulated);
        }
    
    public:
        t_solution(void) {
            get_input();
            solve();
        }
};

int main(void) {
    t_solution s;
    return 0;
}