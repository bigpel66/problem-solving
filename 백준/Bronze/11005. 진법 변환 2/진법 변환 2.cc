#include <iostream>
#include <string>

using namespace std;

class sol {
    private:
        int number;
        int base;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> number >> base;
        }
    
        string to_n_base() {
            static const string& preset("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            string temp;
            while(number) {
                temp.push_back(preset[number % base]);
                number /= base;
            }
            return string(temp.rbegin(), temp.rend());
        }
    
        void solve(void) {
            cout << to_n_base();
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