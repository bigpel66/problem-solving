#include <climits>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using node = pair<int, int>;

class sol {
private:
    int number_of_city;
    int number_of_road;
    int begin, end;
    vector<long long> distance;
    vector<vector<node>> matrix;
    priority_queue<node> pq;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_city >> number_of_road;
        distance = vector<long long>(number_of_city + 1, INT_MAX);
        matrix = vector<vector<node>>(number_of_city + 1);
        int from, to, cost;
        for (int i = 0 ; i < number_of_road ; i++) {
            cin >> from >> to >> cost;
            matrix[from].push_back({cost, to});
        }
        cin >> begin >> end;
        pq.push({0, begin});
        distance[begin] = 0;
    }

    void dijkstra(void) {
        while(!pq.empty()) {
            int cur_cost = -pq.top().first;
            int cur_node = pq.top().second;
            pq.pop();
            if (distance.at(cur_node) < cur_cost) {
                continue;
            }
            for (size_t i = 0 ; i < matrix.at(cur_node).size() ; i++) {
                int next_cost = cur_cost + matrix.at(cur_node).at(i).first;
                int next_node = matrix.at(cur_node).at(i).second;
                if (next_cost < distance.at(next_node)) {
                    pq.push({-next_cost, next_node});
                    distance[next_node] = next_cost;
                }
            }
        }
    }

    void solve(void) {
        dijkstra();
        cout << distance.at(end);
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