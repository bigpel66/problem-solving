#include <cctype>
#include <cmath>
#include <iostream>
#include <string>

using namespace std;

class sol {
    private:
        string number;
        int base;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> number >> base;
        }
    
        int to_decimal(void) {
            int acc = 0;
            for (int i = number.length() - 1 ; i >= 0 ; i--) {
                if (isdigit(number.at(i))) {
                    acc += pow(base, number.length() - 1 - i) * (number.at(i) - '0');
                } else {
                    acc += pow(base, number.length() - 1 - i) * (number.at(i) - 'A' + 10);
                }
            }
            return acc;
        }
    
        void solve(void) {
            cout << to_decimal();
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