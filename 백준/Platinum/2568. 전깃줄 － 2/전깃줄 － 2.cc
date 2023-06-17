#include <algorithm>
#include <iostream>
#include <set>
#include <utility>
#include <vector>

using namespace std;
using elec = pair<int, int>;

class sol {
private:
    int number_of_line, lis_count;
    vector<elec> sequence;
    vector<int> index, data;
    set<int> order;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_line;
        lis_count = 0;
        sequence = vector<elec>(number_of_line);
        for (int i = 0 ; i < number_of_line ; i++) {
            cin >> sequence[i].first >> sequence[i].second;
            order.insert(sequence.at(i).first);
        }
        sort(sequence.begin(), sequence.end(), less<>());
    }

    void solve(void) {
        for (int i = 0 ; i < number_of_line ; i++) {
            const elec& e = sequence.at(i);
            int cur_index = lower_bound(data.begin(), data.end(), e.second) - data.begin();
            index.push_back(cur_index);
            if (data.begin() + cur_index == data.end()) {
                data.push_back(e.second);
                lis_count++;
            } else {
                data[cur_index] = e.second;
            }
        }
        cout << number_of_line - lis_count << '\n';
        for (int i = number_of_line - 1 ; i >= 0 ; i--) {
            if (index.at(i) == lis_count - 1) {
                order.erase(sequence.at(i).first);
                lis_count--;
            }
        }
        for (auto&& i : order) {
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