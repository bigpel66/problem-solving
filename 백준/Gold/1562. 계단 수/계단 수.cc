#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int target_digits, answer;
    vector<vector<vector<int>>> dp;

    static const int& MOD;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> target_digits;
        answer = 0;
        dp = vector<vector<vector<int>>>(10, vector<vector<int>>(101, vector<int>(1024, 0)));
    }

    bool is_all_number_visited(int bitset) {
        return bitset == 1023;
    }

    int dfs(int current_number, int ongoing_digits, int bitset) {
        if (dp.at(current_number).at(ongoing_digits).at(bitset)) {
            return dp.at(current_number).at(ongoing_digits).at(bitset);
        }
        if (ongoing_digits == target_digits) {
            return is_all_number_visited(bitset);
        }
        int temp = 0;
        if (current_number < 9) {
            temp += dfs(current_number + 1, ongoing_digits + 1, bitset | (1 << current_number + 1)) % MOD;
        }
        if (current_number > 0) {
            temp += dfs(current_number - 1, ongoing_digits + 1, bitset | (1 << current_number - 1)) % MOD;
        }
        return dp[current_number][ongoing_digits][bitset] = temp % MOD;
    }

    void solve(void) {
        for (int i = 1 ; i <= 9 ; i++) {
            answer += dfs(i, 1, 1 << i) % MOD;
            answer %= MOD;
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

const int& sol::MOD = 1'000'000'000;

int main(void) {
    sol ve;
    return 0;
}