#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_sequence, count;
    vector<int> sequence, data;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_sequence;
        count = 0;
        sequence = vector<int>(number_of_sequence, 0);
        for (int i = 0 ; i < number_of_sequence ; i++) {
            cin >> sequence[i];
        }
    }

    void solve(void) {
        for (int i = 0 ; i < number_of_sequence ; i++) {
            int cur_value = sequence.at(i);
            int cur_index = lower_bound(data.begin(), data.end(), cur_value) - data.begin();
            if (cur_index + data.begin() == data.end()) {
                data.push_back(sequence.at(i));
                count++;
            } else {
                data[cur_index] = sequence.at(i);
            }
        }
        cout << count;
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