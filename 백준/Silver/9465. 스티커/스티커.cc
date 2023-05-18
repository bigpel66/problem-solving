#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int number_of_test;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_test;
	}

	void solve(void) {
		int row;
		for (int i = 0; i < number_of_test; i++) {
			cin >> row;
			vector<vector<int>> dp(2, vector<int>(row + 1, 0));
			for (int j = 0; j < 2; j++) {
				for (int k = 1; k <= row; k++) {
					cin >> dp[j][k];
				}
			}
			for (int j = 2; j <= row; j++) {
				dp[0][j] = dp[0][j] + max({ dp[1][j - 1], dp[0][j - 2], dp[1][j - 2] });
				dp[1][j] = dp[1][j] + max({ dp[0][j - 1], dp[0][j - 2], dp[1][j - 2] });
			}
			cout << max({ dp[0][row], dp[1][row] }) << '\n';
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