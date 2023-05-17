#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int n;
        int cut;
        vector<int> vec;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n >> cut;
            int temp;
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                vec.push_back(temp);
            }
            sort(vec.begin(), vec.end(), greater<int>());
        }
        
        void solve(void) {
            cout << vec.at(cut - 1);
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