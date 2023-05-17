#include <iostream>
#include <numeric>
#include <vector>

using namespace std;

class sol {
    private:
        int n;
        int temp;
        vector<int> v;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
        }
        
        void solve(void) {
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                if (!temp) {
                    v.pop_back();
                } else {
                    v.push_back(temp);
                }
            }
            if (v.empty()) {
                cout << '0';
            } else {
                cout << accumulate(v.begin(), v.end(), 0);
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