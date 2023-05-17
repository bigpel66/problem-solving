#include <utility>
#include <vector>
#include <queue>

using namespace std;

int solution(int x, int y, int n) {
    if (x == y) {
        return 0;
    }
    vector<bool> is_visited(y + 1, false);
    queue<pair<int, int>> q;
    q.push(pair<int, int>(x, 0));
    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();
        int value = cur.first;
        int next_stage = cur.second + 1;
        is_visited[value] = true;
        if (value + n == y || value * 2 == y || value * 3 == y) {
            return next_stage;
        }
        vector<int> candidates;
        candidates.insert(candidates.end(), {value + n, value * 2, value * 3});
        for (auto&& i : candidates) {
            if (i < y && !is_visited[i]) {
                q.push(pair<int, int>(i, next_stage));    
            }
        }
    }
    return -1;
}