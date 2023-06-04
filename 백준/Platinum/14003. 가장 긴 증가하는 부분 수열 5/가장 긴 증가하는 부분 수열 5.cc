#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_sequence, count;
    vector<int> sequence, data, index, answer;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_sequence;
        count = 0;
        sequence = vector<int>(number_of_sequence);
        for (int i = 0 ; i < number_of_sequence ; i++) {
            cin >> sequence[i];
        }
    }

    void solve(void) {
        for (int i = 0 ; i < number_of_sequence ; i++) {
            int cur_value = sequence.at(i);
            int cur_index = lower_bound(data.begin(), data.end(), cur_value) - data.begin();
            index.push_back(cur_index);
            if (cur_index + data.begin() == data.end()) {
                data.push_back(sequence.at(i));
                count++;
            } else {
                data[cur_index] = sequence.at(i);
            }
        }
        cout << count << '\n';
        for (int i = index.size() - 1 ; i >= 0 ; i--) {
            if (index.at(i) == count - 1) {
                answer.push_back(sequence.at(i));
                count--;
            }
        }
        for (auto&& iter = answer.rbegin() ; iter != answer.rend() ; iter++) {
            cout << *iter << ' ';
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