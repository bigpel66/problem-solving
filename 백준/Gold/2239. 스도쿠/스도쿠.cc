#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	vector<vector<int>> v;
	vector<vector<bool>> row;
	vector<vector<bool>> col;
	vector<vector<bool>> square;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		v = vector<vector<int>>(9, vector<int>(9, 0));
		row = vector<vector<bool>>(9, vector<bool>(10, false));
		col = vector<vector<bool>>(9, vector<bool>(10, false));
		square = vector<vector<bool>>(9, vector<bool>(10, false));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c;
				cin >> c;
				v[i][j] = c - '0';
				if (v.at(i).at(j)) {
					row[i][v.at(i).at(j)] = true;
					col[j][v.at(i).at(j)] = true;
					square[i / 3 * 3 + j / 3][v.at(i).at(j)] = true;
				}
			}
		}
	}

	void dfs(int count) {
		int x = count / 9;
		int y = count % 9;
		int index = x / 3 * 3 + y / 3;
		if (count == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					cout << v.at(i).at(j);
				}
				cout << '\n';
			}
			exit(0);
		}
		if (v.at(x).at(y)) {
			dfs(count + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (row.at(x).at(i) || col.at(y).at(i) || square.at(index).at(i)) {
					continue;
				}
				row[x][i] = true;
				col[y][i] = true;
				square[index][i] = true;
				v[x][y] = i;
				dfs(count + 1);
				v[x][y] = 0;
				square[index][i] = false;
				col[y][i] = false;
				row[x][i] = false;
			}
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