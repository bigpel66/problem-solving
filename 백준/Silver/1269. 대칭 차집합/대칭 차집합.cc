#include <algorithm>
#include <iostream>
#include <set>
#include <vector>

using namespace std;

class sol {
    private:
        size_t s1_size;
        size_t s2_size;
        set<int> s1;
        set<int> s2;
        vector<int> s1_diff;
        vector<int> s2_diff;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> s1_size >> s2_size;
            int temp;
            for (size_t i = 0 ; i < s1_size ; i++) {
                cin >> temp;
                s1.insert(temp);
            }
            for (size_t i = 0 ; i < s2_size ; i++) {
                cin >> temp;
                s2.insert(temp);
            }
            s1_diff = vector<int>(s1_size);
            s2_diff = vector<int>(s2_size);
        }
        
        void solve(void) {
            auto&& iter1 = set_difference(s1.begin(), s1.end(), s2.begin(), s2.end(), s1_diff.begin());
            s1_diff.resize(iter1 - s1_diff.begin());
            auto&& iter2 = set_difference(s2.begin(), s2.end(), s1.begin(), s1.end(), s2_diff.begin());
            s2_diff.resize(iter2 - s2_diff.begin());
            cout << s1_diff.size() + s2_diff.size();
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