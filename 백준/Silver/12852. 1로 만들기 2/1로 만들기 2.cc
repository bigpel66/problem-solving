#include <iostream>
#include <vector>

using namespace std;
using node = pair<int, int>;

class sol {
private:
	int number;
	vector<int> dp;
	vector<int> before;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number;
		dp = vector<int>(number + 1, 0);
		before = vector<int>(number + 1, 0);
	}

	void solve(void) {
		for (int i = 2; i <= number; i++) {
			dp[i] = dp[i - 1] + 1;
			before[i] = i - 1;
			if (!(i % 3) && dp.at(i) > dp.at(i / 3) + 1) {
				dp[i] = dp[i / 3] + 1;
				before[i] = i / 3;
			}
			if (!(i % 2) && dp.at(i) > dp.at(i / 2) + 1) {
				dp[i] = dp[i / 2] + 1;
				before[i] = i / 2;
			}
		}
		cout << dp.at(number) << '\n';
		while (number) {
			cout << number << ' ';
			number = before.at(number);
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