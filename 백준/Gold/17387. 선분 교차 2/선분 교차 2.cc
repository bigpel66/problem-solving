#include <iostream>
#include <utility>

using namespace std;
using point = pair<long long, long long>;
using line = pair<point, point>;

class sol {
private:
    line l1, l2;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> l1.first.first >> l1.first.second >> l1.second.first >> l1.second.second;
        cin >> l2.first.first >> l2.first.second >> l2.second.first >> l2.second.second;
        if (l1.first > l1.second) {
            swap(l1.first, l1.second);
        }
        if (l2.first > l2.second) {
            swap(l2.first, l2.second);
        }
    }

    int ccw(const point& p1, const point& p2, const point& p3) {
        long long value = p1.first * p2.second + p2.first * p3.second + p3.first * p1.second - p2.first * p1.second - p3.first * p2.second - p1.first * p3.second;
        if (value > 0) {
            return 1;
        } else if (value < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    bool is_intersect(void) {
        int line_1_intersect_direction = ccw(l1.first, l1.second, l2.first) * ccw(l1.first, l1.second, l2.second);
        int line_2_intersect_direction = ccw(l2.first, l2.second, l1.first) * ccw(l2.first, l2.second, l1.second);
        if (line_1_intersect_direction > 0 || line_2_intersect_direction > 0) {
            return false;
        }
        if (line_1_intersect_direction == 0 && line_2_intersect_direction == 0) {
            return l1.first <= l2.second && l2.first <= l1.second;
        } else {
            return true;
        }
    }

    void solve(void) {
        cout << (is_intersect() ? 1 : 0);
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