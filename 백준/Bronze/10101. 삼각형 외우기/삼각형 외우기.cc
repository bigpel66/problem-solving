#include <iostream>
#include <unordered_set>

using namespace std;

class sol {
    private:
        int x, y, z;
        int acc;
        unordered_set<int> us;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> x >> y >> z;
            acc = x + y + z;
            us.insert(x);
            us.insert(y);
            us.insert(z);
        }
        
        void solve(void) {
            if (acc != 180) {
                cout << "Error";
                return;
            }
            if (us.size() == 1) {
                cout << "Equilateral";
            } else if (us.size() == 2) {
                cout << "Isosceles";
            } else {
                cout << "Scalene";
            }
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