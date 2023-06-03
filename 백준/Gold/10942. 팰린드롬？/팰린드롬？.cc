#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int sequence_size, number_of_query, begin, end;
    vector<int> sequence;
    vector<vector<bool>> dp;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> sequence_size;
        sequence = vector<int>(sequence_size + 1, 0);
        dp = vector<vector<bool>>(sequence_size + 1, vector<bool>(sequence_size + 1, false));
        for (int i = 1 ; i <= sequence_size ; i++) {
            cin >> sequence[i];
        }
        cin >> number_of_query;
    }

    void generate_palindrome_table(void) {
        for (int i = 1 ; i <= sequence_size ; i++) {
            dp[i][i] = true;
            if (i < sequence_size && sequence.at(i) == sequence.at(i + 1)) {
                dp.at(i).at(i + 1) = true;
            }
        }
        for (int i = sequence_size - 1 ; i >= 1 ; i--) {
            for (int j = i + 2 ; j <= sequence_size ; j++) {
                if (sequence.at(i) == sequence.at(j) && dp.at(i + 1).at(j - 1)) {
                    dp[i][j] = true;
                }
            }
        }
    }

    void solve(void) {
        generate_palindrome_table();
        for (int i = 0 ; i < number_of_query ; i++) {
            cin >> begin >> end;
            cout << dp.at(begin).at(end) << '\n';
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