#include <iostream>
#include <string>
#include <stack>

using namespace std;

int solution(string s) {
    stack<char> st;
    for (int i = 0 ; i < s.length() ; i++) {
        if (st.empty()) {
            st.push(s.at(i));
            continue;
        }
        if (st.top() != s.at(i)) {
            st.push(s.at(i));
        } else {
            st.pop();
        }
    }
    return st.empty() ? 1 : 0;
}