#include <cctype>
#include <iostream>
#include <string>

using namespace std;

class t_solution {
    private:
        void get_input() {
            cin >> s;
        }
    
        void solve() {
            for (auto&& i : s) {
                if (isupper(i)) {
                    i = tolower(i);
                } else {
                    i = toupper(i);
                }
            }
            cout << s;
        }
        
    public:
        string s;
        
        t_solution() {
            get_input();
            solve();
        }
};

int main() {
    t_solution s;
    return 0;
}