#include <climits>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class sol {
private:
    string str;
    size_t size;
    vector<int> dp;
    vector<vector<bool>> is_palindrome;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> str;
        size = str.length();
        str.insert(0, " ");
        dp = vector<int>(size + 1, 0);
        is_palindrome = vector<vector<bool>>(size + 1, vector<bool>(size + 1, false));
    }

    void find_palindrome(void) {
        for (size_t i = 1 ; i <= size ; i++) {
            is_palindrome[i][i] = true;
            if (i < size && str.at(i) == str.at(i + 1)) {
                is_palindrome[i][i + 1] = true;
            }
        }
        for (size_t i = size - 1 ; i >= 1 ; i--) {
            for (size_t j = i + 2 ; j <= size ; j++) {
                if (str.at(i) == str.at(j) && is_palindrome.at(i + 1).at(j - 1)) {
                    is_palindrome[i][j] = true;
                }
            }
        }
    }

    void solve(void) {
        find_palindrome();
        for (int end = 1 ; end <= size ; end++) {
            dp[end] = INT_MAX;
            for (int begin = 1 ; begin <= end ; begin++) {
                if (is_palindrome.at(begin).at(end)) {
                    dp[end] = min(dp.at(end), dp.at(begin - 1) + 1);
                }
            }
        }
        cout << dp.at(size);
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