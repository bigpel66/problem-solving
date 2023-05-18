#include <iostream>

using namespace std;

class sol {
private:
	int a, b, c;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> a >> b >> c;
	}

	long long div_and_conq(int power) {
		if (power == 0) {
			return 1;
		}
		if (power == 1) {
			return a % c;
		}
		long long value = div_and_conq(power / 2);
		if (power % 2) {
			return ((value % c * value % c) * (a % c)) % c;
		}
		else {
			return (value % c * value % c) % c;
		}
	}

	void solve(void) {
		cout << div_and_conq(b);
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