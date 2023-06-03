#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    string s1, s2, answer;
    vector<vector<int>> dp;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> s1 >> s2;
        dp = vector<vector<int>>(s1.length() + 1, vector<int>(s2.length() + 1, 0));
    }

    void longgest_common_subsequence(void) {
        for (size_t i = 0 ; i < s1.length() ; i++) {
            for (size_t j = 0 ; j < s2.length() ; j++) {
                if (s1.at(i) == s2.at(j)) {
                    dp[i + 1][j + 1] = dp.at(i).at(j) + 1;
                } else {
                    dp[i + 1][j + 1] = max(dp.at(i + 1).at(j), dp.at(i).at(j + 1));
                }
            }
        }
    }

    void find_word(void) {
        int row = s1.length();
        int col = s2.length();
        while (dp.at(row).at(col)) {
            if (dp.at(row).at(col) == dp.at(row - 1).at(col)) {
                row--;
            } else if (dp.at(row).at(col) == dp.at(row).at(col - 1)) {
                col--;
            } else {
                row--, col--;
                answer += s1.at(row);
            }
        }
        answer = string(answer.rbegin(), answer.rend());
    }

    void solve(void) {
        longgest_common_subsequence();
        find_word();
        cout << dp.at(s1.length()).at(s2.length()) << '\n' << answer;
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