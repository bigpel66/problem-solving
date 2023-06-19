#include <iostream>

using namespace std;

class sol {
private:
    string expression;
    int count, answer;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> expression;
        count = answer = 0;
    }

    void solve(void) {
        for (size_t i = 0 ; i < expression.length() - 1 ; i++) {
            if (expression.at(i) == '(' && expression.at(i + 1) == ')') {
                answer += count;
                i++;
            } else if (expression.at(i) == '(') {
                count++;
            } else if (expression.at(i) == ')') {
                count--;
                answer++;
            }
        }
        cout << (expression.at(expression.length() - 2) == ')' ? ++answer : answer);
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