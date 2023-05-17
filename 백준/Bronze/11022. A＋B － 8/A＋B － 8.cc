#include <iostream>

using namespace std;

class t_sol {
    private:
        int n;
        int a, b;
    
        void set_stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void solve(void) {
            cin >> n;
            for (int i = 0 ; i < n ; i++) {
                cin >> a >> b;
                cout << "Case #" << i + 1 << ": " << a << " + " << b << " = " << a + b << '\n';
            }
        }
    
    public:
        t_sol(void) {
            set_stream();
            solve();
        }
};

int main(void) {
    t_sol s;
    return 0;
}