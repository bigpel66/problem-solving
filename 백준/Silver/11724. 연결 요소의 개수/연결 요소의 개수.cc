#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class sol {
private:
    int n, number_of_edge, answer;
    vector<int> parent;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> n >> number_of_edge;
        for (int i = 0 ; i <= n ; i++) {
            parent.push_back(i);
        }
        answer = n;
    }

    int get_parent(int i) {
        if (parent.at(i) == i) {
            return i;
        }
        return parent[i] = get_parent(parent.at(i));
    }

    bool union_parent(int i, int j) {
        i = get_parent(i);
        j = get_parent(j);
        parent[j] = i;
        return i != j;
    }

    void solve(void) {
        int a, b;
        for (int i = 0 ; i < number_of_edge ; i++) {
            cin >> a >> b;
            if (union_parent(a, b)) {
                answer--;
            }
        }
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