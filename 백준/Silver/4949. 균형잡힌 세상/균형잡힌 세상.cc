#include <iostream>
#include <stack>

using namespace std;

class sol {
    private:
        string s;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        string is_balanced_parenthesis(string& s) {
            stack<char> st;
            for (size_t i = 0 ; i < s.length() ; i++) {
                if (s.at(i) == '(' || s.at(i) == '[') {
                    st.push(s.at(i));
                } else if (s.at(i) == ')' || s.at(i) == ']') {
                    if (st.empty()) {
                        return "no";
                    }
                    if (s.at(i) == ')' && st.top() != '(') {
                        return "no";
                    }
                    if (s.at(i) == ']' && st.top() != '[') {
                        return "no";
                    }
                    st.pop();
                }
            }
            return st.empty() ? "yes" : "no";
        }
        
        void solve(void) {
            while (true) {
                getline(cin, s);
                if (s == ".") {
                    break;
                }
                cout << is_balanced_parenthesis(s) << '\n';
            }
        }

    public:
        sol(void) {
            stream();
            solve();
        }
};

int main(void) {
    sol ve;
    return 0;
}