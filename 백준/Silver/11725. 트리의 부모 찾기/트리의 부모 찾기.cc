#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class sol {
private:
	int n;
	queue<int> q;
	vector<int> parent;
	vector<vector<int>> matrix;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n;
		parent = vector<int>(n + 1, -1);
		matrix = vector<vector<int>>(n + 1);
		int node_1, node_2;
		for (int i = 0; i < n - 1; i++) {
			cin >> node_1 >> node_2;
			matrix[node_1].push_back(node_2);
			matrix[node_2].push_back(node_1);
		}
		q.push(1);
		parent[0] = parent[1] = 0;
	}

	void solve(void) {
		while (!q.empty()) {
			int cur = q.front();
			q.pop();
			for (auto&& i : matrix.at(cur)) {
				if (parent.at(i) != -1) {
					continue;
				}
				parent[i] = cur;
				q.push(i);
			}
		}
		for (int i = 2; i <= n; i++) {
			cout << parent.at(i) << '\n';
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
