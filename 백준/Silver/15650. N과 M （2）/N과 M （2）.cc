#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int n, m;
	vector<int> v;
	vector<bool> is_visited;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n >> m;
		is_visited = vector<bool>(n + 1, false);
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
			if (is_visited.at(i) || (!v.empty() && v.back() > i)) {
				continue;
			}
			v.push_back(i);
			is_visited[i] = true;
			dfs(count + 1);
			is_visited[i] = false;
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