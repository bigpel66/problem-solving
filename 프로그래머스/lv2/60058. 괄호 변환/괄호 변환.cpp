#include <string>
#include <stack>

using namespace std;

int balanced_position(string& s) {
    int open = 0;
    int close = 0;
    for (int i = 0 ; i < s.length() ; i++) {
        if (s.at(i) == '(') {
            open++;
        } else {
            close++;
        }
        if (open == close) {
            return i + 1;
        }
    }
    return -1;
}

bool is_completed(string s) {
    stack<char> st;
    for (auto&& i : s) {
        if (i == ')' && !st.empty()) {
            st.pop();
        }
        if (i == '(') {
            st.push(i);
        }
    }
    return st.empty();
}

string solution(string p) {
    if (p.empty()) {
        return "";
    }
    int&& index = balanced_position(p);
    auto&& u = p.substr(0, index);
    auto&& v = p.substr(index);
    if (is_completed(u)) {
        return u + solution(v);
    } else {
        string s1 = "(" + solution(v) + ")";
        string s2 = u.substr(1, u.length() - 2);
        for (auto&& i : s2) {
            if (i == '(') {
                i = ')';
            } else {
                i = '(';
            }
        }
        return s1 + s2;
    }
}