#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int number_of_liquid, liquid1, liquid2, compound;
	vector<int> liquid;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_liquid;
		liquid = vector<int>(number_of_liquid);
		for (int i = 0; i < number_of_liquid; i++) {
			cin >> liquid[i];
		}
	}

	void solve(void) {
		int left = 0;
		int right = liquid.size() - 1;
		liquid1 = liquid.at(left);
		liquid2 = liquid.at(right);
		compound = abs(liquid1 + liquid2);
		while (left < right) {
			int temp_liquid1 = liquid.at(left);
			int temp_liquid2 = liquid.at(right);
			int temp_compound = temp_liquid1 + temp_liquid2;
			if (compound > abs(temp_compound)) {
				liquid1 = temp_liquid1;
				liquid2 = temp_liquid2;
				compound = abs(temp_compound);
			}
			if (temp_compound < 0) {
				left++;
			} else {
				right--;
			}
		}
		cout << liquid1 << ' ' << liquid2;
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