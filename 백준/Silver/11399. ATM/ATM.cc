#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int n;
        int sum;
        vector<int> v;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
            sum = 0;
            int temp;
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                v.push_back(temp);
            }
            sort(v.begin(), v.end(), less<int>());
        }
        
        void solve(void) {
            for (size_t i = 0 ; i < v.size() ; i++) {
                sum += v.at(i) * (v.size() - i);
            }
            cout << sum;
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