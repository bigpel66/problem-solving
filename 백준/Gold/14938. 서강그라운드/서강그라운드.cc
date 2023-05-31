#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int number_of_region, search_range, number_of_edge, answer;
	vector<vector<int>> distance;
	vector<int> item;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_region >> search_range >> number_of_edge;
		answer = SHRT_MIN;
		distance = vector<vector<int>>(number_of_region + 1, vector<int>(number_of_region + 1, SHRT_MAX));
		for (int i = 0; i <= number_of_region; i++) {
			distance[i][i] = 0;
		}
		item = vector<int>(number_of_region + 1, 0);
		for (int i = 1; i <= number_of_region; i++) {
			cin >> item[i];
		}
		int from, to, cost;
		for (int i = 0; i < number_of_edge; i++) {
			cin >> from >> to >> cost;
			distance[from][to] = cost;
			distance[to][from] = cost;
		}
	}

	void floyd_warshall(void) {
		for (int k = 1; k <= number_of_region; k++) {
			for (int i = 1; i <= number_of_region; i++) {
				for (int j = 1; j <= number_of_region; j++) {
					if (distance.at(i).at(j) > distance.at(i).at(k) + distance.at(k).at(j)) {
						distance[i][j] = distance.at(i).at(k) + distance.at(k).at(j);
					}
				}
			}
		}
	}

	void solve(void) {
		floyd_warshall();
		for (int i = 1; i <= number_of_region; i++) {
			int acc = item.at(i);
			for (int j = 1; j <= number_of_region; j++) {
				if (i == j) {
					continue;
				}
				if (distance.at(i).at(j) <= search_range) {
					acc += item.at(j);
				}
			}
			answer = max(answer, acc);
		}
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