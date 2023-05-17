#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;
using note = unordered_map<string, string>;

class sol {
private:
	string domain, password;
	int number_of_domain;
	int number_of_find;
	note n;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_domain >> number_of_find;
		for (int i = 0; i < number_of_domain; i++) {
			cin >> domain >> password;
			n[domain] = password;
		}
	}

	void solve(void) {
		for (int i = 0; i < number_of_find; i++) {
			cin >> domain;
			cout << n.at(domain) << '\n';
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