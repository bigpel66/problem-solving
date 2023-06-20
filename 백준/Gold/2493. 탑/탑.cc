#include <iostream>
#include <stack>
#include <utility>
#include <vector>

using namespace std;
using building = pair<int, int>;

class sol {
private:
    int number_of_building;
    stack<building> st;
    vector<int> answer;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_building;
    }

    void solve(void) {
        int height;
        for (int i = 1 ; i <= number_of_building ; i++) {
            cin >> height;
            while (!st.empty() && st.top().first < height) {
                st.pop();
            }
            if (st.empty()) {
                answer.push_back(0);
            } else {
                answer.push_back(st.top().second);
            }
            st.push({height, i});
        }
        for (auto&& i : answer) {
            cout << i << ' ';
        }
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