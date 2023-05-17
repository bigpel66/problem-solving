#include <cmath>
#include <iostream>
#include <map>
#include <set>

using namespace std;

class sol {
private:
	int number_of_query;
	map<int, multiset<int>> m;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_query;
	}

	void solve(void) {
		int temp;
		for (int i = 0; i < number_of_query; i++) {
			cin >> temp;
			if (temp) {
				m[abs(temp)].insert(temp);
			} else {
				if (m.empty()) {
					cout << 0 << '\n';
				}
				else {
					auto&& iter = m.begin()->second.begin();
					cout << *iter << '\n';
					m.begin()->second.erase(iter);
					if (m.begin()->second.empty()) {
						m.erase(m.begin());
					}
				}
			}
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