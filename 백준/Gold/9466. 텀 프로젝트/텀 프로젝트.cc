#include <iostream>
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

    void dfs(const vector<int>& match, vector<bool>& is_visited, vector<bool>& is_cycle_already_checked, int& count, int cur_person) {
        is_visited[cur_person] = true;
        int next_person = match.at(cur_person);
        if (!is_visited.at(next_person)) {
            dfs(match, is_visited, is_cycle_already_checked, count, next_person);
        } else if (!is_cycle_already_checked.at(next_person)) {
            for (int i = next_person ; i != cur_person ; i = match.at(i)) {
                count++;
            }
            count++;
        }
        is_cycle_already_checked[cur_person] = true;
    }

    void solve(void) {
        int number_of_person, count;
        cin >> number_of_person;
        count = 0;
        vector<bool> is_visited(number_of_person + 1, false);
        vector<bool> is_cycle_already_checked(number_of_person + 1,  false);
        vector<int> match(number_of_person + 1, 0);
        for (int i = 1 ; i <= number_of_person ; i++) {
            cin >> match[i];
        }
        for (int i = 1 ; i <= number_of_person ; i++) {
            if (is_visited.at(i)) {
                continue;
            }
            dfs(match, is_visited, is_cycle_already_checked, count, i);
        }
        cout << number_of_person - count << '\n';
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