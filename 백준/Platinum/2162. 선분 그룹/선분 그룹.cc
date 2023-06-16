#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;
using line = pair<point, point>;

class sol {
private:
    int number_of_line, group_count, max_count;
    vector<line> v;
    vector<int> count;
    vector<int> parent;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_line;
        v = vector<line>(number_of_line);
        count = vector<int>(number_of_line, 0);
        parent = vector<int>(number_of_line, 0);
        group_count = 0;
        max_count = 0;
        for (int i = 0 ; i < number_of_line ; i++) {
            cin >> v[i].first.first >> v[i].first.second >> v[i].second.first >> v[i].second.second;
            if (v[i].first > v[i].second) {
                swap(v[i].first, v[i].second);
            }
        }
        for (int i = 1 ; i < number_of_line ; i++) {
            parent[i] = i;
        }
    }

    int ccw(const point& p1, const point& p2, const point& p3) {
        int result = (p1.first * p2.second + p2.first * p3.second + p3.first * p1.second) - (p2.first * p1.second + p3.first * p2.second + p1.first * p3.second);
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    bool is_intersect(const line& l1, const line& l2) {
        int is_line_1_intersect = ccw(l1.first, l1.second, l2.first) * ccw(l1.first, l1.second, l2.second);
        int is_line_2_intersect = ccw(l2.first, l2.second, l1.first) * ccw(l2.first, l2.second, l1.second);
        if (is_line_1_intersect > 0 || is_line_2_intersect > 0) {
            return false;
        }
        if (is_line_1_intersect == 0 && is_line_2_intersect == 0) {
            return l1.first <= l2.second && l2.first <= l1.second;
        } else {
            return true;
        }
    }

    int find_parent(int index) {
        if (index == parent.at(index)) {
            return index;
        }
        return parent[index] = find_parent(parent.at(index));
    }

    void union_parent(int index1, int index2) {
        index1 = find_parent(index1);
        index2 = find_parent(index2);
        if (index1 == index2) {
            return;
        }
        if (index1 < index2) {
            parent[index2] = index1;
        } else {
            parent[index1] = index2;
        }
    }

    void solve(void) {
        for (int i = 0 ; i < number_of_line - 1 ; i++) {
            for (int j = i + 1 ; j < number_of_line ; j++) {
                if (is_intersect(v.at(i), v.at(j))) {
                    union_parent(i, j);
                }
            }
        }
        for (int i = 0 ; i < number_of_line ; i++) {
            count[find_parent(i)]++;
        }
        for (int i = 0 ; i < number_of_line ; i++) {
            if (count.at(i)) {
                group_count++;
                max_count = max(max_count, count.at(i));
            }
        }
        cout << group_count << '\n' << max_count;
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