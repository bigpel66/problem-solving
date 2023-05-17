#include <iostream>
#include <string>

using namespace std;

class t_sol {
    private:
        string s;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> s;        
        }
    
        void solve(void) {
            cout << (s == string(s.rbegin(), s.rend()) ? 1 : 0);
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