#include <iostream>
#include <queue>
#include <string>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
private:
	int n;
	int n_count, d_count;
	vector<string> v;
	vector<vector<bool>> is_visited;
	queue<point> q;

	static const vector<vector<int>>& displacement;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n;
		n_count = d_count = 0;
		string temp;
		for (int i = 0; i < n; i++) {
			cin >> temp;
			v.push_back(temp);
		}
	}

	void bfs(int x, int y) {
		q.push({ x, y });
		is_visited[x][y] = true;
		while (!q.empty()) {
			point p = q.front();
			q.pop();
			for (size_t i = 0; i < displacement.size(); i++) {
				int next_x = p.first + displacement.at(i).at(0);
				int next_y = p.second + displacement.at(i).at(1);
				if (next_x < 0 || next_y < 0
					|| next_x >= n || next_y >= n
					|| is_visited.at(next_x).at(next_y)) {
					continue;
				}
				if (v.at(p.first).at(p.second) == v.at(next_x).at(next_y)) {
					q.push({ next_x, next_y });
					is_visited[next_x][next_y] = true;
				}
			}
		}
	}

	void solve(void) {
		is_visited = vector<vector<bool>>(n, vector<bool>(n, false));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!is_visited.at(i).at(j)) {
					bfs(i, j);
					n_count++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (v.at(i).at(j) == 'R') {
					v[i][j] = 'G';
				}
			}
		}
		is_visited = vector<vector<bool>>(n, vector<bool>(n, false));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!is_visited.at(i).at(j)) {
					bfs(i, j);
					d_count++;
				}
			}
		}
		cout << n_count << '\n' << d_count;
	}

public:
	sol(void) {
		stream();
		get_input();
		solve();
	}
};

const vector<vector<int>>& sol::displacement{ {-1, 0}, {0, -1}, {0, 1}, {1, 0} };

int main(void) {
	sol ve;
	return 0;
}