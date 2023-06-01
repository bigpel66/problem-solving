#include <climits>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using node = pair<int, int>;

class sol {
private:
	int number_of_city, number_of_road;
	int begin, end;
	vector<int> route, distance, path;
	vector<vector<node>> matrix;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_city >> number_of_road;
		route = vector<int>(number_of_city + 1, 0);
		distance = vector<int>(number_of_city + 1, INT_MAX / 2);
		matrix = vector<vector<node>>(number_of_city + 1);
		int from, to, cost;
		for (int i = 0; i < number_of_road; i++) {
			cin >> from >> to >> cost;
			matrix[from].push_back({ cost, to });
		}
		cin >> begin >> end;
	}

	void dijkstra(void) {
		priority_queue<node> pq;
		pq.push({ 0, begin });
		distance[begin] = 0;
		while (!pq.empty()) {
			int cur_cost = -pq.top().first;
			int cur_node = pq.top().second;
			pq.pop();
			if (distance.at(cur_node) < cur_cost) {
				continue;
			}
			for (size_t i = 0; i < matrix.at(cur_node).size(); i++) {
				int next_cost = cur_cost + matrix.at(cur_node).at(i).first;
				int next_node = matrix.at(cur_node).at(i).second;
				if (distance.at(next_node) > next_cost) {
					distance[next_node] = next_cost;
					pq.push({ -next_cost, next_node });
					route[next_node] = cur_node;
				}
			}
		}
	}

	void solve(void) {
		dijkstra();
		cout << distance.at(end) << '\n';
		int temp = end;
		while (temp) {
			path.push_back(temp);
			temp = route.at(temp);
		}
		cout << path.size() << '\n';
		for (auto&& iter = path.rbegin(); iter != path.rend(); iter++) {
			cout << *iter << ' ';
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