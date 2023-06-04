#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    vector<int> sequence;
    vector<vector<vector<int>>> dp;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        int temp;
        while (true) {
            cin >> temp;
            if (!temp) {
                break;
            }
            sequence.push_back(temp);
        }
        dp = vector<vector<vector<int>>>(5, vector<vector<int>>(5, vector<int>(sequence.size(), -1)));
    }

    int check_cost(int from, int to) {
        if (from == 0) {
            return 2;
        } else if (from == to) {
            return 1;
        } else if (abs(from - to) == 2) {
            return 4;
        } else {
            return 3;
        }
    }

    int ddr(int left, int right, int count) {
        if (count == sequence.size()) {
            return 0;
        }
        if (dp.at(left).at(right).at(count) != -1) {
            return dp.at(left).at(right).at(count);
        }
        int left_cost = ddr(sequence.at(count), right, count + 1) + check_cost(left,sequence.at(count));
        int right_cost = ddr(left, sequence.at(count), count + 1) + check_cost(right, sequence.at(count));
        return dp[left][right][count] = min(left_cost, right_cost);
    }

    void solve(void) {
        cout << ddr(0, 0, 0);
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