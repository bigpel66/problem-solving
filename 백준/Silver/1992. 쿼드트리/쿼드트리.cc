#include <iostream>
#include <string>
#include <vector>

using namespace std;

class sol {
private:
	int n;
	vector<string> v;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> n;
		v = vector<string>(n, string(n, '0'));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> v[i][j];
			}
		}
	}

	bool is_unified(int x, int y, int n) {
		char value = v.at(x).at(y);
		for (int i = x ; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (value != v.at(i).at(j)) {
					return false;
				}
			}
		}
		return true;
	}

	string div_and_conq(int x, int y, int size) {
		if (is_unified(x, y, size)) {
			return string(1, v.at(x).at(y));
		}
		return "(" 
			+ div_and_conq(x, y, size / 2) 
			+ div_and_conq(x, y + size / 2, size / 2) 
			+ div_and_conq(x + size / 2, y, size / 2) 
			+ div_and_conq(x + size / 2, y + size / 2 , size / 2) 
			+ ")";
	}

	void solve(void) {
		cout << div_and_conq(0, 0, n);
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