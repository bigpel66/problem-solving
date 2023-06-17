#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_card;
    int number_of_own;
    int number_of_comp;
    vector<int> order;
    vector<int> minsu;
    vector<int> parent;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_card >> number_of_own >> number_of_comp;
        order = vector<int>(number_of_comp);
        minsu = vector<int>(number_of_own);
        parent = vector<int>(number_of_card);
        for (int i = 0 ; i < number_of_own ; i++) {
            cin >> minsu[i];
        }
        for (int i = 0 ; i < number_of_comp ; i++) {
            cin >> order[i];
        }
        for (int i = 1 ; i < number_of_card ; i++) {
            parent[i] = i;
        }
        sort(minsu.begin(), minsu.end(), less<int>());
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
        if (index1 > index2) {
            parent[index2] = index1;
        } else {
            parent[index1] = index2;
        }
    }

    void solve(void) {
        for (int i = 0 ; i < number_of_comp ; i++) {
            int index = lower_bound(minsu.begin(), minsu.end(), order.at(i) + 1) - minsu.begin();
            cout << minsu.at(find_parent(index)) << '\n';
            if (index < number_of_card - 1) {
                union_parent(find_parent(index), find_parent(index) + 1);
            }
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