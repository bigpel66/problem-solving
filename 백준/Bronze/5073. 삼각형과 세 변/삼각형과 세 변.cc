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
            while (true) {
                cin >> x >> y >> z;
                if (x == 0 && y == 0 && z == 0) {
                    return;
                }
                acc = x + y + z;
                s.insert(x);
                s.insert(y);
                s.insert(z);
                if (acc - *s.rbegin() <= *s.rbegin()) {
                    cout << "Invalid\n";
                } else if (s.size() == 1) {
                     cout << "Equilateral\n";
                } else if (s.size() == 2) {
                    cout << "Isosceles\n";
                } else {
                    cout << "Scalene\n";
                }
                s.clear();
            }
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