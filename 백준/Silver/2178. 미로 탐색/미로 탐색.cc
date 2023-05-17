#include <climits>
#include <cmath>
#include <iostream>
#include <queue>
#include <string>
#include <tuple>
#include <vector>

using namespace std;

class sol {
private:
	int row, col, answer;
	vector<string> v;
	vector<vector<bool>> c;
	queue<tuple<int, int, int>> q;

	static const vector<vector<int>>& displacement;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> row >> col;
		answer = INT_MAX;
		v = vector<string>(row, string(col, '\0'));
		c = vector<vector<bool>>(row, vector<bool>(col, false));
		for (int i = 0 ; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cin >> v[i][j];
			}
		}
		c[0][0] = true;
		q.push({ 1, 0, 0 });
	}

	void bfs(void) {
		while (!q.empty()) {
			int cost, x, y;
			tie(cost, x, y) = q.front();
			q.pop();
			for (size_t i = 0; i < displacement.size(); i++) {
				int next_x = x + displacement.at(i).at(0);
				int next_y = y + displacement.at(i).at(1);
				if (next_x < 0 || next_y < 0 
					|| next_x >= row || next_y >= col 
					|| c.at(next_x).at(next_y) 
					|| v.at(next_x).at(next_y) != '1') {
					continue;
				}
				if (next_x == row - 1 && next_y == col - 1) {
					answer = cost + 1;
					return;
				}
				c[next_x][next_y] = true;
				q.push({ cost + 1, next_x, next_y });
			}
		}
	}

	void solve(void) {
		bfs();
		cout << answer;
	}

public:
	sol(void) {
		stream();
		get_input();
		solve();
	}
};

const vector<vector<int>>& sol::displacement{ {-1,0}, {0, -1}, {0, 1}, {1, 0} };

int main(void) {
	sol ve;
	return 0;
}