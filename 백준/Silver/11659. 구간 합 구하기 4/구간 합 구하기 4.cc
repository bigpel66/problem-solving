#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int number_of_element;
	int number_of_query;
	vector<int> sum;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_element >> number_of_query;
		sum = vector<int>(number_of_element + 1, 0);
		for (int i = 1 ; i <= number_of_element; i++) {
			cin >> sum[i];
			sum[i] += sum[i - 1];
		}
	}

	void solve(void) {
		int a, b;
		for (int i = 0; i < number_of_query; i++) {
			cin >> a >> b;
			cout << sum.at(b) - sum.at(a - 1) << '\n';
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