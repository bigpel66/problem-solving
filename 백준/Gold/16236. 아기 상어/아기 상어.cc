#include <climits>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
private:
    int n;
    int answer;
    int cur_x, cur_y, cur_size, cur_eat;
    vector<vector<int>> v;

    static const vector<vector<int>>& displacement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> n;
        answer = 0;
        v = vector<vector<int>>(n, vector<int>(n, 0));
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                cin >> v[i][j];
                if (v.at(i).at(j) == 9) {
                    cur_x = i;
                    cur_y = j;
                    cur_size = 2;
                    cur_eat = 0;
                }
            }
        }
    }

    bool is_bait(int x, int y) {
        return v.at(x).at(y) != 9 && v.at(x).at(y) != 0 && v.at(x).at(y) < cur_size;
    }

    bool is_pass(int x, int y) {
        return !v.at(x).at(y) || v.at(x).at(y) == cur_size;
    }

    void bfs(queue<point>& q, vector<vector<int>>& distance) {
        while (!q.empty()) {
            point p = q.front();
            q.pop();
            for (size_t i = 0 ; i < displacement.size() ; i++) {
                int next_x = p.first + displacement.at(i).at(0);
                int next_y = p.second + displacement.at(i).at(1);
                if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= n || distance.at(next_x).at(next_y) != INT_MAX) {
                    continue;
                }
                if (is_pass(next_x, next_y)) {
                    distance[next_x][next_y] = distance[p.first][p.second] + 1;
                    q.push({next_x, next_y});
                } else if (is_bait(next_x, next_y)) {
                    distance[next_x][next_y] = distance[p.first][p.second] + 1;
                }
            }
        }
    }

    bool is_consumable(vector<vector<int>>& distance) {
        int temp = INT_MAX;
        int temp_x, temp_y;
        for (int i = distance.size() - 1 ; i >= 0 ; i--) {
            for (int j = distance.size() - 1 ; j >= 0 ; j--) {
                if (temp >= distance.at(i).at(j) && is_bait(i, j)) {
                    temp = distance.at(i).at(j);
                    temp_x = i;
                    temp_y = j;
                }
            }
        }
        if (temp == INT_MAX) {
            return false;
        }
        v[cur_x][cur_y] = 0;
        cur_x = temp_x;
        cur_y = temp_y;
        v[cur_x][cur_y] = 9;
        answer += temp;
        if (++cur_eat == cur_size) {
            cur_eat = 0;
            cur_size++;
        }
        return true;
    }

    bool is_standalone() {
        queue<point> q;
        vector<vector<int>> distance(n, vector<int>(n , INT_MAX));
        q.push({cur_x, cur_y});
        distance[cur_x][cur_y] = 0;
        bfs(q, distance);
        return is_consumable(distance);
    }

    void solve(void) {
        while (is_standalone()) ;
        cout << answer;
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

const vector<vector<int>>& sol::displacement{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

int main(void) {
    sol ve;
    return 0;
}