#include <iostream>

using namespace std;

class sol {
    private:
        int a, b;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> a >> b;
        }
        
        void solve(void) {
            cout << a * b;
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