#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using node = pair<int, int>;

class sol {
private:
    int number_of_node, number_of_edge;
    int waypoint1, waypoint2;
    vector<vector<node>> matrix;

    static const int& MAX;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_node >> number_of_edge;
        matrix = vector<vector<node>>(number_of_node + 1);
        int from, to, cost;
        for (int i = 0 ; i < number_of_edge ; i++) {
            cin >> from >> to >> cost;
            matrix.at(from).push_back({cost, to});
            matrix.at(to).push_back({cost, from});
        }
        cin >> waypoint1 >> waypoint2;
    }

    vector<int> dijkstra(int index) {
        vector<int> distance(number_of_node + 1, MAX);
        distance[index] = 0;
        priority_queue<node> pq;
        pq.push({0, index});
        while (!pq.empty()) {
            int cur_cost = -pq.top().first;
            int cur_node = pq.top().second;
            pq.pop();
            if (distance.at(cur_node) < cur_cost) {
                continue;
            }
            for (size_t i = 0 ; i < matrix.at(cur_node).size() ; i++) {
                int next_cost = cur_cost + matrix.at(cur_node).at(i).first;
                int next_node = matrix.at(cur_node).at(i).second;
                if (distance.at(next_node) > next_cost) {
                    distance[next_node] = next_cost;
                    pq.push({-next_cost, next_node});
                }
            }
        }
        return distance;
    }

    void solve(void) {
        vector<int>&& from_origin = dijkstra(1);
        vector<int>&& from_waypoint1 = dijkstra(waypoint1);
        vector<int>&& from_waypoint2 = dijkstra(waypoint2);
        int distance1 = from_origin.at(waypoint1) + from_waypoint1.at(waypoint2) + from_waypoint2.at(number_of_node);
        int distance2 = from_origin.at(waypoint2) + from_waypoint2.at(waypoint1) + from_waypoint1.at(number_of_node);
        if (distance1 >= MAX && distance2 >= MAX) {
            cout << -1;
        } else if (distance1 < distance2) {
            cout << distance1;
        } else {
            cout << distance2;
        }
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

const int& sol::MAX = 100'000'000;

int main(void) {
    sol ve;
    return 0;
}