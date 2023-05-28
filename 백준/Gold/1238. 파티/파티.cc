#include <climits>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using node = pair<int, int>;

class sol {
private:
    int number_of_city, number_of_road, goal;
    vector<vector<node>> matrix1;
    vector<vector<node>> matrix2;
    vector<int> distance1;
    vector<int> distance2;

    static const int& MAX;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_city >> number_of_road >> goal;
        matrix1 = vector<vector<node>>(number_of_city + 1);
        matrix2 = vector<vector<node>>(number_of_city + 1);
        distance1 = vector<int>(number_of_city + 1, MAX);
        distance2 = vector<int>(number_of_city + 1, MAX);
        int from, to, cost;
        for (int i = 0 ; i < number_of_road ; i++) {
            cin >> from >> to >> cost;
            matrix1[from].push_back({cost, to});
            matrix2[to].push_back({cost, from});
        }
        distance1[goal] = 0;
        distance2[goal] = 0;
    }

    void dijkstra(const vector<vector<node>>& matrix, vector<int>& distance) {
        priority_queue<node> pq;
        pq.push({0, goal});
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
    }

    void solve(void) {
        dijkstra(matrix1, distance1);
        dijkstra(matrix2, distance2);
        int temp = INT_MIN;
        for (int i = 1 ; i <= number_of_city ; i++) {
            if (distance1.at(i) != MAX && distance2.at(i) != MAX && distance1.at(i) + distance2.at(i) > temp) {
                temp = distance1.at(i) + distance2.at(i);
            }
        }
        cout << temp;
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