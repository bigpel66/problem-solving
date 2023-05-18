#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int n, m;
	vector<vector<int>> v;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n >> m;
		v = vector<vector<int>>(n + 1, vector<int>(n + 1, 0));
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				cin >> v[i][j];
				v[i][j] += v[i][j - 1];
			}
		}
	}

	void solve(void) {
		int x1, y1, x2, y2;
		int sum;
		for (int i = 0; i < m; i++) {
			sum = 0;
			cin >> x1 >> y1 >> x2 >> y2;
			for (int j = x1; j <= x2; j++) {
				sum += v.at(j).at(y2) - v.at(j).at(y1 - 1);
			}
			cout << sum << '\n';
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