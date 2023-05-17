#include <iostream>
#include <string>
#include <stack>

using namespace std;

string shift(string s) {
    s = s.substr(1) + s.substr(0, 1);
    return s;
}

bool is_valid(string s) {
    stack<char> st;
    for (int i = 0 ; i < s.length() ; i++) {
        char ch = s.at(i);
        if (st.empty()) {
            st.push(ch);
            continue;
        }
        char top = st.top();
        switch (ch) {
            case '}':
                if (top == '{') {
                    st.pop();
                } else {
                    return false;
                }
                break;
            case ']':
                if (top == '[') {
                    st.pop();
                } else {
                    return false;
                }
                break;
            case ')':
                if (top == '(') {
                    st.pop();
                } else {
                    return false;
                }
                break;
            default:
                st.push(ch);
        }
    }
    return st.empty();
}

int solution(string s) {
    if (s.length() == 1) {
        return false;
    }
    int answer = 0;
    for (int i = 0 ; i < s.length() ; i++) {
        s = shift(s);
        if (is_valid(s)) {
            answer++;
        }
    }
    return answer;
}