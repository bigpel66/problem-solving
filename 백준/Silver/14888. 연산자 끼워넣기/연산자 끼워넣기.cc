#include <algorithm>
#include <climits>
#include <iostream>

using namespace std;

class sol {
private:
    int max_value, min_value;
    int number_of_operand;
    vector<int> number;
    vector<int> count;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_operand;
        number = vector<int>(number_of_operand);
        count = vector<int>(4, 0);
        for (int i = 0 ; i < number_of_operand ; i++) {
            cin >> number[i];
        }
        for (int i = 0 ; i < 4 ; i++) {
            cin >> count[i];
        }
        max_value = INT_MIN;
        min_value = INT_MAX;
    }

    void dfs(int acc, int index) {
        if (index == number_of_operand - 1) {
            max_value = max(max_value, acc);
            min_value = min(min_value, acc);
            return;
        }
        for (size_t i = 0 ; i < count.size() ; i++) {
            if (!count.at(i)) {
                continue;
            }
            count[i]--;
            if (i == 0) {
                dfs(acc + number[index + 1], index + 1);
            } else if (i == 1) {
                dfs(acc - number[index + 1], index + 1);
            } else if (i == 2) {
                dfs(acc * number[index + 1], index + 1);
            } else {
                dfs(acc / number[index + 1], index + 1);
            }
            count[i]++;
        }
    }

    void solve(void) {
        dfs(number.at(0), 0);
        cout << max_value << '\n' << min_value;
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