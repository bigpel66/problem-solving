#include <iostream>
#include <vector>

using namespace std;

enum e_shape {
	HORIZONTAL,
	VERTICAL,
	DIAGONAL
};

class sol {
private:
	int grid_size, answer;
	vector<vector<int>> matrix;
	
	static const vector<vector<int>>& displacement;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> grid_size;
		answer = 0;
		matrix = vector<vector<int>>(grid_size + 1, vector<int>(grid_size + 1, 0));
		for (int i = 1; i <= grid_size; i++) {
			for (int j = 1; j <= grid_size; j++) {
				cin >> matrix[i][j];
			}
		}
	}

	void dfs(int row, int col, e_shape shape) {
		if (row == grid_size && col == grid_size) {
			answer++;
			return;
		}
		for (size_t i = 0; i < displacement.size(); i++) {
			if ((i == 0 && shape == VERTICAL) || (i == 1 && shape == HORIZONTAL)) {
				continue;
			}
			int next_row = row + displacement.at(i).at(0);
			int next_col = col + displacement.at(i).at(1);
			if (next_row < 1 || next_col < 1 || next_row > grid_size || next_col > grid_size) {
				continue;
			}
			if (matrix.at(next_row).at(next_col) == 1 || (i == 2 && (matrix.at(next_row - 1).at(next_col) == 1 || matrix.at(next_row).at(next_col - 1) == 1))) {
				continue;
			}
			dfs(next_row, next_col, static_cast<e_shape>(i));
		}
	}

	void solve(void) {
		dfs(1, 2, HORIZONTAL);
		cout << answer;
	}

public:
	sol(void) {
		stream();
		get_input();
		solve();
	}
};

const vector<vector<int>>& sol::displacement{ {0, 1}, {1, 0}, {1, 1} };

int main(void) {
	sol ve;
	return 0;
}