#include <iostream>
#include <vector>

using namespace std;

class t_sol {
    private:
        static const vector<int>& original;
        vector<int> vec;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            vec = vector<int>(6, 0);
            for (auto&& i : vec) {
                cin >> i;
            }
        }
    
        void solve(void) {
            for (int i = 0 ; i < vec.size() ; i++) {
                cout << original.at(i) - vec.at(i) << ' ';
            }
        }
    
    public:
        t_sol(void) {
            stream();
            get_input();
            solve();
        }
};

const vector<int>& t_sol::original = {1, 1, 2, 2, 2, 8};

int main(void) {
    t_sol s;
    return 0;
}