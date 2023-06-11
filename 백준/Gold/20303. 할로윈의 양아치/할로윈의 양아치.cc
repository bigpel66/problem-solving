#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_friend;
    int number_of_relationship;
    int limit;
    vector<int> dp;
    vector<int> candy;
    vector<int> parent;
    vector<int> collegue;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    int find_parent(int index) {
        if (index == parent.at(index)) {
            return index;
        }
        return parent[index] = find_parent(parent.at(index));
    }

    void union_parent(int index1, int index2) {
        index1 = find_parent(index1);
        index2 = find_parent(index2);
        if (index1 == index2) {
            return;
        }
        if (index1 < index2) {
            parent[index2] = index1;
        } else {
            parent[index1] = index2;
        }
    }

    void get_input(void) {
        cin >> number_of_friend >> number_of_relationship >> limit;
        candy = vector<int>(number_of_friend + 1, 0);
        parent = vector<int>(number_of_friend + 1, 0);
        collegue = vector<int>(number_of_friend + 1, 1);
        for (int i = 1 ; i <= number_of_friend ; i++) {
            cin >> candy[i];
            parent[i] = i;
        }
        int from, to;
        for (int i = 0 ; i < number_of_relationship ; i++) {
            cin >> from >> to;
            union_parent(from, to);
        }
        for (int i = 1 ; i <= number_of_friend ; i++) {
            parent[i] = find_parent(i);
        }
    }

    void solve(void) {
        for (int i = 1 ; i <= number_of_friend ; i++) {
            if (parent.at(i) == i) {
                continue;
            }
            candy[parent.at(i)] += candy.at(i);
            collegue[parent.at(i)]++;
        }
        dp = vector<int>(limit,  0);
        for (int i = 1 ; i <= number_of_friend ; i++) {
            if (parent.at(i) != i) {
                continue;
            }
            for (int j = limit - 1 ; j - collegue.at(i) >= 0 ; j--) {
                dp[j] = max(dp.at(j), dp.at(j - collegue.at(i)) + candy.at(i));
            }
        }
        cout << dp.at(limit - 1);
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
