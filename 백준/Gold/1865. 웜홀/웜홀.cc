#include <climits>
#include <iostream>
#include <tuple>
#include <vector>

using namespace std;
using node = tuple<int, int, int>;

class sol {
private:
    int number_of_test;
    int number_of_node;
    int number_of_edge;
    int number_of_worm;
    vector<int> distance;
    vector<node> matrix;

    static const int& INF;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_test;
    }

    bool is_negative_cycle(int number_of_node) {
        distance[1] = 0;
        for (int i = 1 ; i < number_of_node ; i++) {
            for (size_t j = 0 ; j < matrix.size() ; j++) {
                int from, to, cost;
                tie(from, to, cost) = matrix.at(j);
                if (distance.at(to) > distance.at(from) + cost) {
                    distance[to] = distance.at(from) + cost;
                }
            }
        }
        for (size_t i = 0 ; i < matrix.size() ; i++) {
            int from, to, cost;
            tie(from, to, cost) = matrix.at(i);
            if (distance.at(to) > distance.at(from) + cost) {
                return true;
            }
        }
        return false;
    }

    void solve(void) {
        cin >> number_of_node >> number_of_edge >> number_of_worm;
        distance = vector<int>(number_of_node + 1, INF);
        int from, to, cost;
        for (int i = 0 ; i < number_of_edge ; i++) {
            cin >> from >> to >> cost;
            matrix.push_back({from, to, cost});
            matrix.push_back({to, from, cost});
        }
        for (int i = 0 ; i < number_of_worm ; i++) {
            cin >> from >> to >> cost;
            matrix.push_back({from, to, -cost});
        }
        cout << (is_negative_cycle(number_of_node) ? "YES\n" : "NO\n");
        distance.clear();
        matrix.clear();
    }

public:
    sol(void) {
        stream();
        get_input();
        for (int i = 0 ; i < number_of_test ; i++) {
            solve();
        }
    }
};

const int& sol::INF = 10'000'000;

int main(void) {
    sol ve;
    return 0;
}