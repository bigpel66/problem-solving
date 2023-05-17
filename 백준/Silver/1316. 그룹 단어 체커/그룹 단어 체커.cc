#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

class t_sol {
    private:
        int n;
        int answer;
        string s;
        unordered_set<char> us;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> n;   
            answer = 0;
        }
    
        bool is_group_word(string& str) {
            us.insert(str.at(0));
            for (int i = 0 ; i < str.length() - 1 ; i++) {
                if (str.at(i) != str.at(i + 1)) {
                    auto&& result = us.insert(str.at(i + 1));
                    if (!result.second) {
                        return false;
                    }
                }
            }
            return true;
        }
    
        void solve(void) {
            for (int i = 0 ; i < n ; i++) {
                cin >> s;
                if (is_group_word(s)) {
                    answer++;
                }
                us.clear();
            }
            cout << answer;
        }
    
    public:    
        t_sol(void) {
            stream();
            get_input();
            solve();
        }
};

int main(void) {
    t_sol s;
    return 0;
}