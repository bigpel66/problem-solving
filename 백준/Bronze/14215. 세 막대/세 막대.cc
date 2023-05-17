#include <iostream>
#include <set>

using namespace std;

class sol {
    private:
        int x, y, z;
        int acc;
        set<int> s;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void solve(void) {
            cin >> x >> y >> z;
            acc = x + y + z;
            s.insert(x);
            s.insert(y);
            s.insert(z);
            if (acc - *s.rbegin() <= *s.rbegin()) {
                int rest = acc - *s.rbegin() - 1;
                acc -= *s.rbegin();
                acc += rest;
            }
            cout << acc;
        }

    public:
        sol(void) {
            stream();
            solve();
        }
};

int main(void) {
    sol ve;
    return 0;
}