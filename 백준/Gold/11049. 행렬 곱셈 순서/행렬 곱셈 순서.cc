#include <algorithm>
#include <climits>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using matrix_size = pair<int, int>;

class sol {
private:
    int number_of_matrix;
    vector<matrix_size> size;
    vector<vector<int>> dp;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_matrix;
        dp = vector<vector<int>>(number_of_matrix + 1, vector<int>(number_of_matrix + 1, 0));
        size = vector<matrix_size>(number_of_matrix + 1);
        for (int i = 1; i <= number_of_matrix ; i++) {
            cin >> size[i].first >> size[i].second;
        }
    }

    void solve(void) {
        for (int k = 1 ; k < number_of_matrix ; k++) {
            for (int i = 1 ; i <= number_of_matrix - k ; i++) {
                dp[i][i + k] = INT_MAX;
                for (int j = i ; j < i + k ; j++) {
                    dp[i][i + k] = min(dp.at(i).at(i + k), dp.at(i).at(j) + dp.at(j + 1).at(i + k) + size.at(i).first * size.at(j).second * size.at(i + k).second);
                }
            }
        }
        cout << dp.at(1).at(number_of_matrix);
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