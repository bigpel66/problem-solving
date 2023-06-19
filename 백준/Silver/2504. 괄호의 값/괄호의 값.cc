#include <algorithm>
#include <iostream>
#include <stack>

using namespace std;

class sol {
private:
    string expression;
    stack<char> st;
    int answer;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> expression;
        answer = 0;
    }

    bool is_correct_parenthesis(void) {
        for (size_t i = 0 ; i < expression.length() ; i++) {
            switch (expression.at(i)) {
                case '(':
                case '[':
                    st.push(expression.at(i));
                    break;
                case ')':
                case ']':
                    if (st.empty()) {
                        return false;
                    }
                    if (expression.at(i) == ')' && st.top() != '(') {
                        return false;
                    }
                    if (expression.at(i) == ']' && st.top() != '[') {
                        return false;
                    }
                    st.pop();
                    break;
            }
        }
        return st.empty();
    }

    int calculate_parenthesis(char back) {
        int temp = 0;
        while (!expression.empty()) {
            char op = expression.back();
            expression.pop_back();
            if (op == ')' || op == ']') {
                temp += calculate_parenthesis(op);
            } else if (back == ')' && op == '(') {
                return 2 * max(1, temp);
            } else if (back == ']' && op == '[') {
                return 3 * max(1, temp);
            }
        }
        return 0;
    }

    void solve(void) {
        if (!is_correct_parenthesis()) {
            cout << 0;
            return;
        }
        while (!expression.empty()) {
            char op = expression.back();
            expression.pop_back();
            answer += calculate_parenthesis(op);
        }
        cout << answer;
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