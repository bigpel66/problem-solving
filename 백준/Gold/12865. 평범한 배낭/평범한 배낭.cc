#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int n, limit;
	vector<int> weight;
	vector<int> value;
	vector<vector<int>> dp;


	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n >> limit;
		weight = vector<int>(n + 1, 0);
		value = vector<int>(n + 1, 0);
		for (int i = 1; i <= n; i++) {
			cin >> weight[i] >> value[i];
		}
		dp = vector<vector<int>>(n + 1, vector<int>(limit + 1, 0));
	}

	void solve(void) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= limit; j++) {
				if (j >= weight.at(i)) {
					dp[i][j] = max(dp.at(i - 1).at(j), dp.at(i - 1).at(j - weight.at(i)) + value.at(i));
				} else {
					dp[i][j] = dp.at(i - 1).at(j);
				}
			}
		}
		cout << dp.at(n).at(limit);
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