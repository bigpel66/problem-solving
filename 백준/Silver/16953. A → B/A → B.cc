#include <iostream>
#include <queue>
#include <utility>

using namespace std;
using point = pair<long long, long long>;

class sol {
private:
	long long a, b;
	queue<point> q;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> a >> b;
		q.push({1, a});
	}

	void solve(void) {
		while (!q.empty()) {
			point cur = q.front();
			q.pop();
			if (cur.second == b) {
				cout << cur.first;
				return;
			}
			long long op1 = cur.second * 2;
			long long op2 = cur.second * 10 + 1;
			if (op1 <=b) {
				q.push({cur.first + 1, op1});
			}
			if (op2 <= b) {
				q.push({cur.first + 1, op2});
			}
		}
		cout << -1;
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