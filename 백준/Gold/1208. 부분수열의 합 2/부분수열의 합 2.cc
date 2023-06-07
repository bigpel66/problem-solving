#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class sol {
private:
    int number_of_sequence, target_sum;
    long long answer;
    vector<int> sequence;
    unordered_map<int, int> um;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_sequence >> target_sum;
        answer = 0;
        sequence = vector<int>(number_of_sequence);
        for (int i = 0 ; i < number_of_sequence ; i++) {
            cin >> sequence[i];
        }
    }

    void accumulate_partial_sum(int index, int sum) {
        if (index == number_of_sequence) {
            um[sum]++;
            return;
        }
        accumulate_partial_sum(index + 1, sum + sequence.at(index));
        accumulate_partial_sum(index + 1, sum);
    }

    void count_target_sum(int index, int sum) {
        if (index == number_of_sequence / 2) {
            answer += um[target_sum - sum];
            return;
        }
        count_target_sum(index + 1, sum + sequence.at(index));
        count_target_sum(index + 1, sum);
    }

    void solve(void) {
        accumulate_partial_sum(number_of_sequence / 2, 0);
        count_target_sum(0, 0);
        if (!target_sum) {
            cout << answer - 1;
        } else {
            cout << answer;
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