#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class sol {
private:
	unordered_map<string, int> um;
	int number_of_test;
	int number_of_entry;
	string key, value;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_test;
	}

	int calc_comb(void) {
		int comb = 1;
		for (auto&& i : um) {
			comb *= (i.second + 1);
		}
		return comb - 1;
	}

	void solve(void) {
		for (int i = 0; i < number_of_test; i++) {
			cin >> number_of_entry;
			for (int j = 0; j < number_of_entry; j++) {
				cin >> value >> key;
				um[key]++;
			}
			cout << calc_comb() << '\n';
			um.clear();
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