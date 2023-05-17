#include <iostream>

using namespace std;

class t_solution {
    private:
        int n;
        int a, b;
    
        void stream_setting(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void solve(void) {
            cin >> n;
            for (int i = 0 ; i < n ; i++) {
                cin >> a >> b;
                cout << "Case #" << i + 1 << ": " << a + b << '\n';
            }
        }
        
    
    public:
        t_solution(void) {
            stream_setting();
            solve();
        }
};

int main(void) {
    t_solution s;
    return 0;
}