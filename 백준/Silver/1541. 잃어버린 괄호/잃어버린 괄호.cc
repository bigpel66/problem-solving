#include <iostream>
#include <string>
#include <regex>
#include <vector>

using namespace std;

class sol {
private:
	string expression;
	vector<int> value;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> expression;
	}

	vector<string> re_split(string& s, const regex& r) {
		vector<string> v;
		regex_token_iterator<string::iterator> iter(s.begin(), s.end(), r, -1);
		regex_token_iterator<string::iterator> end;
		while (iter != end) {
			v.push_back(*iter++);
		}
		return v;
	}

	void solve(void) {
		vector<string>&& v = re_split(expression, regex(R"(\-)"));		
		for (auto&& i : v) {
			vector<string>&& s = re_split(i, regex(R"(\+)"));
			int sum = 0;
			for (auto&& j : s) {
				sum += stoi(j);
			}
			if (sum) {
				value.push_back(sum);
			}
		}
		int sum = 0;
		for (size_t i = 0; i < value.size(); i++) {
			if (!i && !v.at(0).empty()) {
				sum += value.at(i);
			} else {
				sum -= value.at(i);
			}
		}
		cout << sum;
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