#include <algorithm>
#include <iostream>
#include <stack>
#include <tuple>
#include <vector>

using namespace std;
using parenthesis = tuple<int, int, bool>;

class sol {
private:
    int number_of_circle;
    stack<parenthesis> st;
    vector<parenthesis> v;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_circle;
        for (int i = 0 ; i < number_of_circle ; i++) {
            int center, radius;
            cin >> center >> radius;
            v.push_back({center - radius, i, true});
            v.push_back({center + radius, i, false});
        }
        sort(v.begin(), v.end(), less<>());
    }

    bool is_pos_duplicated(void) {
        for (size_t i = 0 ; i < v.size() - 1 ; i++) {
            auto&& [f_pos, f_index, f_is_open] = v.at(i);
            auto&& [l_pos, l_index, l_is_open] = v.at(i + 1);
            if (f_pos == l_pos) {
                return true;
            }
        }
        return false;
    }

    bool is_overlapped(void) {
        for (size_t i = 0 ; i < v.size() ; i++) {
            auto&& [pos, index, is_open] = v.at(i);
            if (is_open) {
                st.push(v.at(i));
            } else {
                auto&& [pre_pos, pre_index, pre_is_open] = st.top();
                if (pre_index != index || !pre_is_open) {
                    return true;
                }
                st.pop();
            }
        }
        return false;
    }

    void solve(void) {
        if (is_pos_duplicated()) {
            cout << "NO";
            return;
        }
        cout << (is_overlapped() ? "NO" : "YES");
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