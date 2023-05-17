#include <iostream>
#include <string>

using namespace std;

class t_solution {
    private:
        int index;
        string s;
        
        void get_input() {
            cin >> s >> index;
        }
    
        void solve() {
            cout << s.at(index - 1);        
        }   
    
    public: 
        t_solution() {
            get_input();
            solve();
        }
};

int main() {
    t_solution s;
    return 0;
}