#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int n;
        vector<int> bound, original;
            
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
            int temp;
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                original.push_back(temp);
            }
            bound = original;
            sort(bound.begin(), bound.end(), less<int>());
            bound.erase(unique(bound.begin(), bound.end()), bound.end());
        }
        
        void solve(void) {
            for (int i = 0 ; i < n ; i++) {
                cout << lower_bound(bound.begin(), bound.end(), original.at(i)) - bound.begin() << ' ';
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