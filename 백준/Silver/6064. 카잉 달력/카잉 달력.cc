#include <iostream>

using namespace std;

class sol {
private:
	int number_of_test;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}	

	void get_input(void) {
		cin >> number_of_test;
	}

	void solve(void) {
		int m, n, x, y;
		for (int i = 0; i < number_of_test; i++) {
			cin >> m >> n >> x >> y;
            x--, y--;
			bool is_possible = false;
			for (int j = x ; j < m * n ; j += m) {
				if (j % n == y) {
					cout << j + 1 << '\n';
					is_possible = true;
					break;
				}
			}
			if (!is_possible) {
				cout << -1 << '\n';
			}
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