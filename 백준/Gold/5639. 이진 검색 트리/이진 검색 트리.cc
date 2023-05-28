#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    vector<int> pre_order;
    vector<int> post_order;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        int value;
        while (cin >> value) {
            pre_order.push_back(value);
        }
    }

    void convert_pre_to_post(int begin, int end) {
        if (begin >= end) {
            return;
        }
        if (begin == end - 1) {
            post_order.push_back(pre_order.at(begin));
            return;
        }
        int index = begin;
        while (index < end) {
            if (pre_order.at(begin) < pre_order.at(index)) {
                break;
            } else {
                index++;
            }
        }
        convert_pre_to_post(begin + 1, index);
        convert_pre_to_post(index, end);
        post_order.push_back(pre_order.at(begin));
    }

    void solve(void) {
        convert_pre_to_post(0, pre_order.size());
        for (auto&& i : post_order) {
            cout << i << '\n';
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