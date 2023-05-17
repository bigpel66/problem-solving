#include <iostream>
#include <string>
#include <string_view>
using namespace std;

class sol {
private:
	int order, length, answer;
	string s;
	string_view sv;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> order >> length >> s;
		answer = 0;
		sv = string_view(s);
	}

	void solve(void) {
		for (size_t i = 0; i < sv.length() - 2 ; i++) {
			int count = 0;
			if (sv.at(i) == 'I' && sv.at(i + 1) == 'O' && sv.at(i + 2) == 'I') {
				count++;
				i += 2;
				while (i + 2 < sv.length() && sv.at(i + 1) == 'O' && sv.at(i + 2) == 'I') {
					i += 2;
					count++;
				}
			}
			if (count >= order) {
				answer += count - order + 1;
			}
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

int main(void) {
	sol ve;
	return 0;
}