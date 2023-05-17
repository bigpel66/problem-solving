#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>

using namespace std;

class t_sol {
    private:
        string a, b;
        string temp;
        size_t diff;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> a >> b;
            reverse(a.begin(), a.end());
            reverse(b.begin(), b.end());
            if (b.length() > a.length()) {
                swap(a, b);
            }
            diff = a.length() - b.length();
            for (size_t i = 0 ; i < diff ; i++) {
                b.push_back('0');
            }
        }
    
        void solve(void) {
            int carry = 0;
            for (size_t i = 0 ; i < a.length() ; i++) {
                int sum = a.at(i) - '0' + b.at(i) - '0' + carry;
                if (sum > 9) {
                    carry = 1;
                    sum -= 10;
                } else {
                    carry = 0;
                }
                temp.push_back('0' + sum);
            }
            if (carry) {
                temp.push_back('1');
            }
            cout << string(temp.rbegin(), temp.rend());
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