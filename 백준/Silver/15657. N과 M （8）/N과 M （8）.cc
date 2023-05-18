#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int n, m;
	vector<int> st;
	vector<int> v;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n >> m;
		v = vector<int>(n, 0);
		for (auto&& i : v) {
			cin >> i;
		}
		sort(v.begin(), v.end(), less<int>());
	}

	void dfs(int count) {
		if (count == m) {
			for (auto&& i : st) {
				cout << i << ' ';
			}
			cout << '\n';
			return;
		}
		for (int i = 0 ; i < n ; i++) {
			if (!st.empty() && st.back() > v.at(i)) {
				continue;
			}
			st.push_back(v.at(i));
			dfs(count + 1);
			st.pop_back();
		}
	}

	void solve(void) {
		dfs(0);
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