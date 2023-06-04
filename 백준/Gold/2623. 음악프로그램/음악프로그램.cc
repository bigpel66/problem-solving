#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_singer, number_of_director;
    vector<int> predecessor, answer;
    vector<vector<int>> arrangement;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_singer >> number_of_director;
        predecessor = vector<int>(number_of_singer + 1, 0);
        arrangement = vector<vector<int>>(number_of_singer + 1);
        for (int i = 0 ; i < number_of_director ; i++) {
            int number_of_part, singer1, singer2;
            cin >> number_of_part;
            if (!number_of_part) {
                continue;
            }
            cin >> singer1;
            for (int j = 1 ; j < number_of_part ; j++) {
                cin >> singer2;
                arrangement[singer1].push_back(singer2);
                predecessor[singer2]++;
                singer1 = singer2;
            }
        }
    }

    void solve(void) {
        queue<int> q;
        for (int i = 1 ; i <= number_of_singer ; i++) {
            if (!predecessor.at(i)) {
                q.push(i);
                answer.push_back(i);
            }
        }
        while (!q.empty()) {
            int cur_singer = q.front();
            q.pop();
            for (size_t i = 0 ; i < arrangement.at(cur_singer).size() ; i++) {
                int next_singer = arrangement.at(cur_singer).at(i);
                predecessor[next_singer]--;
                if (!predecessor.at(next_singer)) {
                    q.push(next_singer);
                    answer.push_back(next_singer);
                }
            }
        }
        if (answer.size() != number_of_singer) {
            cout << 0;
            return;
        }
        for (auto&& i : answer) {
            cout << i << '\n';
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