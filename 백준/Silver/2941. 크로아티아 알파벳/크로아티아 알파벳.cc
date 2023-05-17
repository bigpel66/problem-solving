#include <algorithm>
#include <iostream>
#include <regex>
#include <string>
#include <vector>

using namespace std;

class t_sol {
    private:
        string s;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> s;
        }
    
        vector<string> re_split(string& str, const regex& r) {
            vector<string> vec;
            regex_token_iterator<string::iterator> iter(str.begin(), str.end(), r, -1);
            regex_token_iterator<string::iterator> end;
            while (iter != end) {
                vec.push_back(*iter++);
            }
            return vec;
        }
    
        int re_count(string& str, const regex& r) {
            regex_iterator<string::iterator> iter(str.begin(), str.end(), r);
            regex_iterator<string::iterator> end;
            return distance(iter, end);
        }
    
        void solve(void) {
            int expressable = 0;
            int unexpressable = re_count(s, regex(R"(c=|c-|dz=|d-|lj|nj|s=|z=)"));
            vector<string>&& chars = re_split(s, regex(R"(c=|c-|dz=|d-|lj|nj|s=|z=)"));
            for (auto&& i : chars) {
                expressable += i.length();
            }
            cout << expressable + unexpressable << '\n';
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