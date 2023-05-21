#include <climits>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using node = pair<int, int>;

class sol {
private:
    int number_of_node;
    int number_of_edge;
    int start_node;
    vector<int> dist;
    vector<vector<node>> matrix;
    priority_queue<node> pq;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_node >> number_of_edge >> start_node;
        dist = vector<int>(number_of_node + 1, INT_MAX);
        matrix = vector<vector<node>>(number_of_node + 1);
        int from, to, cost;
        for (int i = 0; i < number_of_edge; i++) {
            cin >> from >> to >> cost;
            matrix[from].push_back({ cost, to });
        }
        dist[start_node] = 0;
        pq.push({ 0, start_node });
    }

    void solve(void) {
        while (!pq.empty()) {
            int cost = -pq.top().first;
            int cur_node = pq.top().second;
            pq.pop();
            if (dist.at(cur_node) < cost) {
                continue;
            }
            for (int i = 0; i < matrix.at(cur_node).size(); i++) {
                int next_cost = matrix.at(cur_node).at(i).first + cost;
                int next_node = matrix.at(cur_node).at(i).second;
                if (dist.at(next_node) > next_cost) {
                    dist[next_node] = next_cost;
                    pq.push({-next_cost, next_node});
                }
            }
        }
        for (int i = 1 ; i <= number_of_node  ;i++) {
            if (dist.at(i) == INT_MAX) {
                cout << "INF" << '\n';
            } else {
                cout << dist.at(i) << '\n';
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