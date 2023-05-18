#include <iostream>
#include <vector>
#include <string>

using namespace std;

class sol {
private:
	int n, m;
	vector<vector<string>> binomial;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n >> m;
		binomial = vector<vector<string>>(n + 1, vector<string>(m + 1, ""));
	}

	string add(string v1, string v2) {
		string temp;
		int carry = 0;
		while (true) {
			int digit = carry;
			if (!v1.empty()) {
				digit += v1.back() - '0';
				v1.pop_back();
			}
			if (!v2.empty()) {
				digit += v2.back() - '0';
				v2.pop_back();
			}
			if (digit >= 10) {
				carry = 1;
				digit -= 10;
			} else {
				carry = 0;
			}
			if (!digit && v1.empty() && v2.empty() && !carry) {
				break;
			}
			temp.push_back(digit + '0');
		}
		return string(temp.rbegin(), temp.rend());
	}

	void solve(void) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (j == 0 || i == j) {
					binomial[i][j] = "1";
				} else {
					binomial[i][j] = add(binomial[i - 1][j], binomial[i - 1][j - 1]);
				}
			}
		}
		cout << binomial[n][m];
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