#include <algorithm>
#include <climits>
#include <iostream>

using namespace std;

class sol {
private:
    int number_of_memory, target_memory, total_cost, answer;
    vector<int> memory;
    vector<int> cost;
    vector<vector<int>> dp;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_memory >> target_memory;
        total_cost = 0;
        answer = INT_MAX;
        memory = vector<int>(number_of_memory + 1);
        cost = vector<int>(number_of_memory + 1);
        for (int i = 1 ; i <= number_of_memory ; i++) {
            cin >> memory[i];
        }
        for (int i = 1 ; i <= number_of_memory ; i++) {
            cin >> cost[i];
            total_cost += cost[i];
        }
        dp = vector<vector<int>>(number_of_memory + 1, vector<int>(total_cost + 1, 0));
    }

    void solve(void) {
        for (int i = 1 ; i <= number_of_memory ; i++) {
            for (int j = 0 ; j <= total_cost ; j++) {
                if (cost.at(i) <= j) {
                    dp[i][j] = max(dp.at(i - 1).at(j), dp.at(i - 1).at(j - cost.at(i)) + memory.at(i));
                } else {
                    dp[i][j] = dp.at(i - 1).at(j);
                }
                if (dp.at(i).at(j) >= target_memory) {
                    answer = min(answer, j);
                }
            }
        }
        cout << answer;
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