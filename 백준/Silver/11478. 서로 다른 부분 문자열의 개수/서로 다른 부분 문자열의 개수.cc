#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

class sol {
    private:
        string s;
        unordered_set<string> dict;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> s;
        }
        
        void solve(void) {
            for (size_t i = 1 ; i <= s.length() ; i++) {
                for (size_t j = 0 ; j + i <= s.length() && j < s.length() ; j++) {
                    dict.insert(s.substr(j, i));
                }
            }
            cout << dict.size();
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