#include <iostream>
#include <queue>
#include <unordered_set>

using namespace std;
using node = pair<int, int>;

class sol {
private:
	int pos_me, pos_bro, time, count;
	unordered_set<int> is_visited;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> pos_me >> pos_bro;
		time = 0;
		count = 0;
	}

	void bfs(void) {
		queue<node> q;
		q.push({ 0, pos_me });
		is_visited.insert(pos_me);
		while (!q.empty()) {
			int cur_time = q.front().first;
			int cur_pos = q.front().second;
			q.pop();
			is_visited.insert(cur_pos);
			if (count && cur_pos == pos_bro && time == cur_time) {
				count++;
			}
			if (!count && cur_pos == pos_bro) {
				count++;
				time = cur_time;
			}
			if (cur_pos * 2 <= 100'000 && !is_visited.count(cur_pos * 2)) {
				q.push({ cur_time + 1, cur_pos * 2 });
			}
			if (cur_pos + 1 <= 100'000 && !is_visited.count(cur_pos + 1)) {
				q.push({ cur_time + 1,  cur_pos + 1 });
			}
			if (cur_pos - 1 >= 0 && !is_visited.count(cur_pos - 1)) {
				q.push({ cur_time + 1, cur_pos - 1 });
			}
		}
	}

	void solve(void) {
		bfs();
		cout << time << '\n' << count;
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