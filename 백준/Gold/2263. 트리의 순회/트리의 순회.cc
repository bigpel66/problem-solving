#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_node;
    vector<int> pre_order;
    vector<int> post_order;
    vector<int> in_order;
    vector<int> in_order_index;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_node;
        in_order = vector<int>(number_of_node + 1, 0);
        in_order_index = vector<int>(number_of_node + 1, 0);
        post_order = vector<int>(number_of_node + 1, 0);
        for (int i = 1 ; i <= number_of_node ; i++) {
            cin >> in_order[i];
            in_order_index[in_order[i]] = i;
        }
        for (int i = 1 ; i <= number_of_node ; i++) {
            cin >> post_order[i];
        }
    }

    void find_pre_order(int in_begin, int in_end, int post_begin, int post_end) {
        if (in_begin > in_end || post_begin > post_end) {
            return;
        }
        int root = post_order.at(post_end);
        int in_order_root_index = in_order_index.at(root);
        int post_order_left_size = in_order_root_index - in_begin;
        pre_order.push_back(root);
        find_pre_order(in_begin, in_order_root_index - 1, post_begin, post_begin + post_order_left_size - 1);
        find_pre_order(in_order_root_index + 1, in_end, post_begin + post_order_left_size, post_end - 1);
    }

    void solve(void) {
        find_pre_order(1, number_of_node, 1, number_of_node);
        for (auto&& i : pre_order) {
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