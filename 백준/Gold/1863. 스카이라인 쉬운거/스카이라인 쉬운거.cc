#include <iostream>
#include <stack>

using namespace std;

class sol {
private:
    int number_of_coord, x, y, answer;
    stack<int> st;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_coord;
        answer = 0;
    }

    void solve(void) {
        for (int i = 0 ; i <= number_of_coord ; i++) {
            if (i != number_of_coord) {
                cin >> x >> y;
            } else {
                y = 0;
            }
            while (!st.empty() && st.top() >= y) {
                if (st.top() > y) {
                    answer++;
                }
                st.pop();
            }
            st.push(y);
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