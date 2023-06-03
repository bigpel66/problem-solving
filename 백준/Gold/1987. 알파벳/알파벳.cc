#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int row, col, answer;
	vector<string> v;
	vector<bool> is_visited;

	static const vector<vector<int>>& displacement;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> row >> col;
		answer = 0;
		v = vector<string>(row, string(col, '\0'));
		is_visited = vector<bool>(26, false);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cin >> v[i][j];
			}
		}
	}

	void dfs(int x, int y, int count) {
		answer = max(answer, count);
		for (size_t i = 0; i < displacement.size(); i++) {
			int nx = x + displacement.at(i).at(0);
			int ny = y + displacement.at(i).at(1);
			if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
				continue;
			}
			if (is_visited.at(v.at(nx).at(ny) - 'A')) {
				continue;
			}
			is_visited[v.at(nx).at(ny) - 'A'] = true;
			dfs(nx, ny, count + 1);
			is_visited[v.at(nx).at(ny) - 'A'] = false;
		}
	}

	void solve(void) {
		is_visited[v.at(0).at(0) - 'A'] = true;
		dfs(0, 0, 1);			
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