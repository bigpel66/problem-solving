#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int n, m;
	vector<int> v;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n >> m;
	}

	void dfs(int count) {
		if (count == m) {
			for (auto&& i : v) {
				cout << i << ' ';
			}
			cout << '\n';
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!v.empty() && v.back() > i) {
				continue;
			}
			v.push_back(i);
			dfs(count + 1);
			v.pop_back();
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