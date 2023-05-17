#include <iostream>
#include <set>

using namespace std;

class sol {
    private:
        int n;
        set<string, greater<string>> s;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
        }
        
        void solve(void) {
            string name, action;
            for (int i = 0 ; i < n ; i++) {
                cin >> name >> action;
                if (action == "enter") {
                    s.insert(name);
                } else {
                    s.erase(name);
                }
            }
            for (auto&& i : s) {
                cout << i << '\n';
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