#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_test;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_test;
    }

    vector<int> topological_sort(int number_of_building, const vector<vector<int>>& topology, const vector<int>& build_time, vector<int>& predecessor) {
        vector<int> result(number_of_building + 1, 0);
        queue<int> q;
        for (int i = 1 ; i <= number_of_building ; i++) {
            if (!predecessor.at(i)) {
                q.push(i);
            }
            result[i] = build_time.at(i);
        }
        while (!q.empty()) {
            int cur_build = q.front();
            q.pop();
            for (size_t i = 0 ; i < topology.at(cur_build).size() ; i++) {
                int next_build = topology.at(cur_build).at(i);
                result[next_build] = max(result.at(next_build), build_time.at(next_build) + result.at(cur_build));
                predecessor[next_build]--;
                if (!predecessor.at(next_build)) {
                    q.push(next_build);
                }
            }
        }
        return result;
    }

    void solve(void) {
        int number_of_building, number_of_edge, from, to, target;
        cin >> number_of_building >> number_of_edge;
        vector<vector<int>> topology(number_of_building + 1);
        vector<int> build_time(number_of_building + 1);
        vector<int> predecessor(number_of_building + 1, 0);
        for (int i = 1 ; i <= number_of_building ; i++) {
            cin >> build_time[i];
        }
        for (int i = 0 ; i < number_of_edge ; i++) {
            cin >> from >> to;
            topology[from].push_back(to);
            predecessor[to]++;
        }
        cin >> target;
        vector<int>&& result = topological_sort(number_of_building, topology, build_time, predecessor);
        cout << result.at(target) << '\n';
    }

public:
    sol(void) {
        stream();
        get_input();
        while (number_of_test--) {
            solve();
        }
    }
};

int main(void) {
    sol ve;
    return 0;
}