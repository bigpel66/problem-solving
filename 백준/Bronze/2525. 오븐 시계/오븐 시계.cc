#include <iostream>

using namespace std;

class t_solution {
    private:
        int hour, minute, duration;
    
        void get_input() {
            cin >> hour >> minute >> duration;
        }
    
        void solve() {
            int result = hour * 60 + minute + duration;
            cout << result / 60 % 24 << ' ' << result % 60;
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