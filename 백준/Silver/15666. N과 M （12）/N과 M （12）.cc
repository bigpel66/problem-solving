#include <algorithm>
#include <iostream>
#include <vector>
#include <set>

using namespace std;

class sol {
private:
	int n, m;
	vector<int> v;
	vector<int> st;
	set<vector<int>> printed;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n >> m;
		v = vector<int>(n, 0);
		for (int i = 0; i < n; i++) {
			cin >> v[i];
		}
		sort(v.begin(), v.end(), less<int>());
	}

	void dfs(int count) {
		if (count == m) {
			if (printed.find(st) != printed.end()) {
				return;
			}
			printed.insert(st);
			for (auto&& i : st) {
				cout << i << ' ';
			}
			cout << '\n';
			return;
		}
		for (auto&& i : v) {
			if (!st.empty() && st.back() > i) {
				continue;
			}
			st.push_back(i);
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