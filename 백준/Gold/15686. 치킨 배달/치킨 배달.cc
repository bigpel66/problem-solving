#include <algorithm>
#include <climits>
#include <cmath>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using node = pair<int, int>;

class sol {
private:
	int grid_size, alive_chicken, answer;
	vector<node> house;
	vector<node> chicken;
	vector<int> choice;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> grid_size >> alive_chicken;
		answer = INT_MAX;
		int status;
		for (int i = 0; i < grid_size; i++) {
			for (int j = 0; j < grid_size; j++) {
				cin >> status;
				if (status == 1) {
					house.push_back({ i, j });
				} else if (status == 2) {
					chicken.push_back({ i, j });
				}
			}
		}
		for (int i = 0; i < chicken.size() - alive_chicken; i++) {
			choice.push_back(0);
		}
		for (int i = 0; i < alive_chicken; i++) {
			choice.push_back(1);
		}
	}

	int l1_distance(node n1, node n2) {
		return abs(n1.first - n2.first) + abs(n1.second - n2.second);
	}

	void calculate_chicken_distance(void) {
		int city_chicken_distance = 0;
		for (size_t i = 0; i < house.size(); i++) {
			int house_chicken_distance = INT_MAX;
			for (size_t j = 0; j < chicken.size(); j++) {
				if (!choice.at(j)) {
					continue;
				}
				int cur_chicken_distance = l1_distance(house.at(i), chicken.at(j));
				house_chicken_distance = min(house_chicken_distance, cur_chicken_distance);
			}
			city_chicken_distance += house_chicken_distance;
		}
		answer = min(answer, city_chicken_distance);
	}

	void solve(void) {
		do {
			calculate_chicken_distance();
		} while (next_permutation(choice.begin(), choice.end()));
		cout << answer;
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