#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using node = pair<int, int>;

class sol {
private:
    int number_of_node;
    int answer, index;
    vector<bool> is_visited;
    vector<vector<node>> matrix;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_node;
        answer = index = 0;
        is_visited = vector<bool>(number_of_node + 1, false);
        matrix = vector<vector<node>>(number_of_node + 1);
        int parent, child, weight;
        for (int i = 0 ; i < number_of_node - 1 ; i++) {
            cin >> parent >> child >> weight;
            matrix[parent].push_back({weight, child});
            matrix[child].push_back({weight, parent});
        }
    }

    void dfs(int node_index, int acc) {
        if (matrix.at(node_index).size() == 1 && is_visited.at(matrix.at(node_index).at(0).second)) {
            if (answer < acc) {
                answer = acc;
                index = node_index;
            }
            return;
        }
        for (int i = 0 ; i < matrix.at(node_index).size() ; i++) {
            int weight = matrix.at(node_index).at(i).first;
            int child = matrix.at(node_index).at(i).second;
            if (is_visited[child]) {
                continue;
            }
            is_visited[child] = true;
            dfs(child, acc + weight);
            is_visited[child] = false;
        }
    }

    void solve(void) {
        is_visited[1] = true;
        dfs(1, 0);
        answer = 0;
        is_visited = vector<bool>(number_of_node + 1, false);
        is_visited[index] = true;
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