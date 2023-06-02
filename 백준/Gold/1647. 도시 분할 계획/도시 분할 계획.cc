#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using node = pair<int, int>;
using weighted_node = pair<int, node>;

class sol {
private:
	int number_of_node, number_of_edge, answer;
	vector<int> parent;
	vector<int> road;
	vector<weighted_node> matrix;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_node >> number_of_edge;
		answer = 0;
		parent = vector<int>(number_of_node + 1, 0);
		for (int i = 1; i <= number_of_node; i++) {
			parent[i] = i;
		}
		int from, to, cost;
		for (int i = 0; i < number_of_edge; i++) {
			cin >> from >> to >> cost;
			matrix.push_back({ cost, { from, to } });
		}
		sort(matrix.begin(), matrix.end(), less<weighted_node>());
	}

	int find_parent(int index) {
		if (index == parent.at(index)) {
			return index;
		}
		return parent[index] = find_parent(parent[index]);
	}

	void union_parent(int index1, int index2) {
		index1 = find_parent(index1);
		index2 = find_parent(index2);
		if (index1 == index2) {
			return;
		}
		if (index1 < index2) {
			parent[index2] = index1;
		} else {
			parent[index1] = index2;
		}
	}

	bool is_same_parent(int index1, int index2) {
		return find_parent(index1) == find_parent(index2);
	}

	void solve(void) {
		for (int i = 0; i < number_of_edge; i++) {
			const int& cost = matrix.at(i).first;
			const node& n = matrix.at(i).second;
			if (!is_same_parent(n.first, n.second)) {
				union_parent(n.first, n.second);
				road.push_back(cost);
			}
		}
		for (size_t i = 0; i < road.size() - 1; i++) {
			answer += road.at(i);
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