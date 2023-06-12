#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_problem, number_of_order;
    priority_queue<int> pq;
    vector<vector<int>> matrix;
    vector<int> predecessor;
    vector<int> answer;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_problem >> number_of_order;
        matrix = vector<vector<int>>(number_of_problem + 1);
        predecessor = vector<int>(number_of_problem + 1, 0);
        int easy, hard;
        for (int i = 0 ; i < number_of_order ; i++) {
            cin >> easy >> hard;
            matrix[easy].push_back(hard);
            predecessor[hard]++;
        }
        for (size_t i = 1 ; i <= number_of_problem ; i++) {
            if (!predecessor.at(i)) {
                pq.push(-i);
            }
        }
    }

    void solve(void) {
        while (!pq.empty()) {
            int cur_value = -pq.top();
            pq.pop();
            answer.push_back(cur_value);
            for (size_t i = 0 ; i < matrix.at(cur_value).size() ; i++ ) {
                int next_value = matrix.at(cur_value).at(i);
                predecessor[next_value]--;
                if (!predecessor.at(next_value)) {
                    pq.push(-next_value);
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