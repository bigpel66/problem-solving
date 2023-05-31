#include <iostream>
#include <string>

using namespace std;

class sol {
private:
	string str, exp, answer;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> str >> exp;
	}

	void solve(void) {
		for (int i = 0; i < str.length(); i++) {
			answer += str.at(i);
			if (answer.back() != exp.back() || answer.length() < exp.length()) {
				continue;
			}
			auto&& exp_iter = exp.rbegin();
			auto&& answer_iter = answer.rbegin();
			bool is_exploded = true;
			while (true) {
				if (exp_iter == exp.rend()) {
					break;
				}
				if (*exp_iter++ != *answer_iter++) {
					is_exploded = false;
					break;
				}
			}
			if (!is_exploded) {
				continue;
			}
			for (int i = 0; i < exp.length(); i++) {
				answer.pop_back();
			}
		}
		cout << (answer.empty() ? "FRULA" : answer);
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