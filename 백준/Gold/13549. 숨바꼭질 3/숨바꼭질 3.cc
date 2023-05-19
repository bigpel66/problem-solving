#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
private:
	int pos_me, pos_bro;
	queue<point> q;
	vector<bool> is_visited;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> pos_me >> pos_bro;
		q.push({ 0, pos_me });
		is_visited = vector<bool>(100'001, false);
	}

	void solve(void) {
		if (pos_me == pos_bro) {
			cout << 0;
			return;
		}
		while (!q.empty()) {
			point p = q.front();
			q.pop();
			if (p.second * 2 < 100'001 && !is_visited.at(p.second * 2)) {
				if (p.second * 2 == pos_bro) {
					cout << p.first;
					return;
				}
				q.push({ p.first, p.second * 2 });
				is_visited[p.second * 2] = true;
			}
			if (p.second - 1 >= 0 && !is_visited.at(p.second - 1)) {
				if (p.second - 1 == pos_bro) {
					cout << p.first + 1;
					return;
				}
				q.push({ p.first + 1, p.second - 1 });
				is_visited[p.second - 1] = true;
			}
			if (p.second + 1 < 100'001 && !is_visited.at(p.second + 1)) {
				if (p.second + 1 == pos_bro) {
					cout << p.first + 1;
					return;
				}
				q.push({ p.first + 1, p.second + 1 });
				is_visited[p.second + 1] = true;
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