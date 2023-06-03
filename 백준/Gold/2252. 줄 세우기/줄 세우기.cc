#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_node, number_of_edge;
    vector<vector<int>> matrix;
    vector<int> predecessor;
    vector<int> answer;
    queue<int> q;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_node >> number_of_edge;
        matrix = vector<vector<int>>(number_of_node + 1);
        predecessor = vector<int>(number_of_node + 1);
        int from, to;
        for (int i = 0 ; i < number_of_edge ; i++) {
            cin >> from >> to;
            matrix[from].push_back(to);
            predecessor[to]++;
        }
    }

    void solve(void) {
        for (int i = 1 ; i <= number_of_node ; i++) {
            if (!predecessor.at(i)) {
                q.push(i);
                answer.push_back(i);
            }
        }
        while (!q.empty()) {
            int cur_node = q.front();
            q.pop();
            for (size_t i = 0 ; i < matrix.at(cur_node).size() ; i++) {
                int next_node = matrix.at(cur_node).at(i);
                predecessor[next_node]--;
                if (!predecessor.at(next_node)) {
                    q.push(next_node);
                    answer.push_back(next_node);
                }
            }
        }
        for (auto&& i : answer) {
            cout << i << ' ';
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