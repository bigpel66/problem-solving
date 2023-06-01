#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using melt = pair<int, int>;

class sol {
private:
	int row, col, answer;
	vector<vector<int>> cheese;
	vector<vector<int>> ferment;
	vector<vector<bool>> is_visited;

	static const vector<vector<int>>& displacement;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> row >> col;
		answer = 0;
		cheese = vector<vector<int>>(row, vector<int>(col));
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cin >> cheese[i][j];
			}
		}
	}

	void bfs(void) {
		ferment = vector<vector<int>>(row, vector<int>(col, 0));
		is_visited = vector<vector<bool>>(row, vector<bool>(col));
		queue<melt> q;
		q.push({ 0, 0 });
		is_visited[0][0] = true;
		while (!q.empty()) {
			int cx = q.front().first;
			int cy = q.front().second;
			q.pop();
			for (size_t i = 0; i < displacement.size(); i++) {
				int nx = cx + displacement.at(i).at(0);
				int ny = cy + displacement.at(i).at(1);
				if (nx < 0 || ny < 0 || nx >= row || ny >= col || is_visited.at(nx).at(ny)) {
					continue;
				}
				if (cheese.at(nx).at(ny)) {
					ferment[nx][ny]++;
				} else {
					q.push({ nx, ny });
					is_visited[nx][ny] = true;
				}
			}
		}
	}

	bool is_melt(void) {
		bool b = false;
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < col - 1; j++) {
				if (ferment.at(i).at(j) >= 2) {
					cheese[i][j] = 0;
					b = true;
				}
			}
		}
		return b;
	}

	void solve(void) {
		while (true) {
			bfs();
			if (is_melt()) {
				answer++;
			}
			else {
				break;
			}
		}
		cout << answer;
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