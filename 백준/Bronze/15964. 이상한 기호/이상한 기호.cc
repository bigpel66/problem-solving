#include <iostream>

using namespace std;

class t_solution {
    private:
        long long x, y;
    
        void get_input(void) {
            cin >> x >> y;
        }
        
        void solve() {
            cout << (x + y) * (x - y);
        }
    
    public:
        t_solution() {
            get_input();
            solve();
        }
};

int main(void) {
    t_solution s;
    return 0;
}