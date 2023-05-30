#include <iostream>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
private:
	int row, col;
	int timelapse, pollution;
	vector<int> cleaner;
	vector<vector<int>> vec;
	vector<vector<int>> temp;

	static const vector<vector<int>>& displacement;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> row >> col >> timelapse;
		pollution = 0;
		vec = vector<vector<int>>(row, vector<int>(col, 0));
		temp = vec;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cin >> vec[i][j];
				if (vec.at(i).at(j) != -1) {
					pollution += vec.at(i).at(j);
				} else {
					cleaner.push_back(i);
				}
			}
		}
	}

	void spread(void) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int divided_value = vec.at(i).at(j) / 5;
				int spreaded_count = 0;
				for (size_t k = 0; k < displacement.size(); k++) {
					int nx = i + displacement.at(k).at(0);
					int ny = j + displacement.at(k).at(1);
					if (nx < 0 || ny < 0 || nx >= row || ny >= col || vec.at(nx).at(ny) == -1) {
						continue;
					}
					temp[nx][ny] += divided_value;
					spreaded_count++;
				}
				vec[i][j] -= spreaded_count * divided_value;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				vec[i][j] += temp.at(i).at(j);
				temp[i][j] = 0;
			}
		}
	}

	void clean(void) {
		int up = cleaner.at(0);
		int down = cleaner.at(1);
		pollution -= vec.at(up - 1).at(0);
		pollution -= vec.at(down + 1).at(0);
		for (int i = up - 1; i > 0; i--) {
			vec[i][0] = vec.at(i - 1).at(0);
		}
		for (int i = 0; i < col - 1; i++) {
			vec[0][i] = vec.at(0).at(i + 1);
		}
		for (int i = 1; i <= up; i++) {
			vec[i - 1][col - 1] = vec.at(i).at(col - 1);
		}
		for (int i = col - 1; i > 1; i--) {
			vec[up][i] = vec.at(up).at(i - 1);
		}
		vec[up][1] = 0;
		for (int i = down + 1; i < row - 1; i++) {
			vec[i][0] = vec.at(i + 1).at(0);
		}
		for (int i = 0; i < col - 1; i++) {
			vec[row - 1][i] = vec.at(row - 1).at(i + 1);
		}
		for (int i = row - 1; i > down; i--) {
			vec[i][col - 1] = vec.at(i - 1).at(col - 1);
		}
		for (int i = col - 1; i > 1; i--) {
			vec[down][i] = vec.at(down).at(i - 1);
		}
		vec[down][1] = 0;
	}

	void solve(void) {
		while (timelapse--) {
			spread();
			if (!cleaner.empty()) {
				clean();
			}
		}
		cout << pollution;
	}

public:
	sol(void) {
		stream();
		get_input();
		solve();
	}
};

const vector<vector<int>>& sol::displacement{ {-1, 0}, {0, -1}, {0, 1}, {1,0} };

int main(void) {
	sol ve;
	return 0;
}