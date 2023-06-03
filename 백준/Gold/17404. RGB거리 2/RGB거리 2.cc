#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_house, answer;
    vector<vector<int>> cost;
    vector<vector<int>> dp;

    static const int& MAX;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_house;
        answer = MAX;
        cost = vector<vector<int>>(number_of_house + 1, vector<int>(3, 0));
        for (int i = 1 ; i <= number_of_house ; i++) {
            cin >> cost[i][0] >> cost[i][1] >> cost[i][2];
        }
    }

    void solve(void) {
        for (int i = 0 ; i < 3 ; i++) {
            dp = vector<vector<int>>(number_of_house + 1, vector<int>(3, 0));
            for (int j = 0 ; j < 3 ; j++) {
                if (i == j) {
                    dp[1][i] = cost[1][i];
                } else {
                    dp[1][j] = MAX;
                }
            }
            for (int j = 2 ; j <= number_of_house ; j++) {
                dp[j][0] = min(dp.at(j - 1).at(1), dp.at(j - 1).at(2)) + cost.at(j).at(0);
                dp[j][1] = min(dp.at(j - 1).at(0), dp.at(j - 1).at(2)) + cost.at(j).at(1);
                dp[j][2] = min(dp.at(j - 1).at(0), dp.at(j - 1).at(1)) + cost.at(j).at(2);
            }
            for (int j = 0 ; j < 3 ; j++) {
                if (i != j) {
                    answer = min(answer, dp.at(number_of_house).at(j));
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

const int& sol::MAX = 4000000;

int main(void) {
    sol ve;
    return 0;
}