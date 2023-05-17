#include <iostream>

using namespace std;

class sol {
    private:
        int n;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
        }
        
        void solve(void) {
            cout << n << '\n' << 1;
        }

    public:
        sol(void) {
            stream();
            get_input();
            solve();
        }
};

int main(void) {
    sol ve;
    return 0;
}