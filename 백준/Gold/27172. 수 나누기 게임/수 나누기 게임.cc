#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_person, max_value;
    vector<int> v;
    vector<int> score;
    vector<bool> is_visited;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_person;
        max_value = INT_MIN;
        v = vector<int>(number_of_person, 0);
        for (int i = 0 ; i < number_of_person ; i++) {
            cin >> v[i];
            max_value = max(max_value, v.at(i));
        }
        score = vector<int>(max_value + 1, 0);
        is_visited = vector<bool>(max_value + 1, false);
        for (int i = 0 ; i < number_of_person ; i++) {
            is_visited[v.at(i)] = true;
        }
    }

    void solve(void) {
        for (auto&& i : v) {
            for (int j = i * 2 ; j <= max_value ; j += i) {
                if (is_visited.at(j)) {
                    score[i]++;
                    score[j]--;
                }
            }
        }
        for (auto&& i : v) {
            cout << score.at(i) << ' ';
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