#include <climits>
#include <cmath>
#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_building;
    stack<int> left_st;
    stack<int> right_st;
    vector<int> heights;
    vector<int> visible;
    vector<int> nearest;


    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_building;
        heights = vector<int>(number_of_building + 1, 0);
        visible = vector<int>(number_of_building + 1, 0);
        nearest = vector<int>(number_of_building + 1, INT_MAX);
        for (int i = 1 ; i <= number_of_building ; i++) {
            cin >> heights[i];
        }
    }

    void search_left_to_right(void) {
        for (int i = 1 ; i <= number_of_building ; i++) {
            while (!left_st.empty() && heights.at(left_st.top()) <= heights.at(i)) {
                left_st.pop();
            }
            visible[i] += left_st.size();
            if (!left_st.empty() && abs(i - left_st.top()) < abs(nearest.at(i) - i)) {
                nearest[i] = left_st.top();
            }
            left_st.push(i);
        }
    }

    void search_right_to_left(void) {
        for (int i = number_of_building ; i >= 1 ; i--) {
            while (!right_st.empty() && heights.at(right_st.top()) <= heights.at(i)) {
                right_st.pop();
            }
            visible[i] += right_st.size();
            if (!right_st.empty() && abs(i - right_st.top()) < abs(nearest.at(i) - i)) {
                nearest[i] = right_st.top();
            }
            right_st.push(i);
        }
    }

    void solve(void) {
        search_left_to_right();
        search_right_to_left();
        for (int i = 1 ; i <= number_of_building ; i++) {
            if (visible.at(i)) {
                cout << visible.at(i) << ' ' << nearest.at(i) << '\n';
            } else {
                cout << 0 << '\n';
            }
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