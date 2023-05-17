#include <iostream>
#include <string>

using namespace std;

class t_solution {
    public:
        string s;
    
        t_solution() {
            cin >> s;
        }
    
        void solve() {
            cout << s.length();
        }
};

int main() {
    t_solution s;
    s.solve();
    return 0;
}