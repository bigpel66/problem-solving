#include <iostream>

using namespace std;
using ll = long long;

class sol {
private:
	int number_of_test;
	ll answer;

	static const int& MOD;
	static const int& POWER;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_test;
		answer = 0;
	}

	ll power(ll denominator, ll count) {
		ll ret = 1;
		while (count) {
			if (count & 1) {
				ret = ret * denominator % MOD;
			}
			count >>= 1;
			denominator = denominator * denominator % MOD;
		}
		return ret;
	}

	void solve(void) {
		ll denominator, numerator;
		cin >> denominator >> numerator;
		answer += numerator * power(denominator, POWER) % MOD;
	}

public:
	sol(void) {
		stream();
		get_input();
		while (number_of_test--) {
			solve();
		}
		cout << answer % MOD;
	}
};

const int& sol::MOD = 1'000'000'007;
const int& sol::POWER = MOD - 2;

int main(void) {
	sol ve;
	return 0;
}