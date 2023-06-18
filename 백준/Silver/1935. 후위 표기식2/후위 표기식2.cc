#include <cctype>
#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_alpha;
    string expression;
    stack<double> st;
    vector<double> value;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_alpha >> expression;
        value = vector<double>(number_of_alpha, 0.0);
        for (int i = 0 ; i < number_of_alpha ; i++) {
            cin >> value[i];
        }
    }

    void solve(void) {
        for (size_t i = 0 ; i < expression.length() ; i++) {
            if (isalpha(expression.at(i))) {
                st.push(value.at(expression.at(i) - 'A'));
            } else {
                char op = expression.at(i);
                double v2 = st.top();
                st.pop();
                double v1 = st.top();
                st.pop();
                if (op == '+') {
                    st.push(v1 + v2);
                } else if (op == '-') {
                    st.push(v1 - v2);
                } else if (op == '*') {
                    st.push(v1 * v2);
                } else if (op == '/') {
                    st.push(v1 / v2);
                }
            }
        }
        cout.precision(2);
        cout << fixed << st.top();
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