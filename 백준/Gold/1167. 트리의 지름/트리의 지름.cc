#include <climits>
#include <cmath>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using node = pair<int, int>;

class sol {
private:
    int number_of_node, delimiter;
    int answer, index;
    vector<vector<node>> tree;
    vector<bool> is_visited;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_node;
        tree = vector<vector<node>>(number_of_node + 1);
        int from, to, cost;
        for (int i = 0 ; i < number_of_node ; i++) {
            cin >> from;
            while (true) {
                cin >> delimiter;
                if (delimiter == -1) {
                    break;
                }
                to = delimiter;
                cin >> cost;
                tree[from].push_back({cost, to});
            }
        }
    }

    void init(void) {
        answer = INT_MIN;
        is_visited = vector<bool>(number_of_node + 1, false);
    }

    void dfs(int node_index, int acc) {
        if (is_visited.at(node_index)) {
            return;
        }
        is_visited[node_index] = true;
        if (answer < acc) {
            answer = acc;
            index = node_index;
        }
        for (size_t i = 0 ; i < tree.at(node_index).size() ; i++) {
            dfs(tree.at(node_index).at(i).second, acc + tree.at(node_index).at(i).first);
        }
    }

    void solve(void) {
        init();
        dfs(1, 0);
        init();
        dfs(index, 0);
        cout << answer;
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