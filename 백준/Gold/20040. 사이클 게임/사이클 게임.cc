#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_node, number_of_edge;
    vector<int> parent;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_node >> number_of_edge;
        parent = vector<int>(number_of_node + 1, 0);
        for (int i = 1 ; i <= number_of_node ; i++) {
            parent[i] = i;
        }
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

    bool is_same_parent(int index1, int index2) {
        return find_parent(index1) == find_parent(index2);
    }

    void solve(void) {
        int a, b;
        for (int i = 0 ; i < number_of_edge ; i++) {
            cin >> a >> b;
            if (!is_same_parent(a, b)) {
                union_parent(a, b);
            } else {
                cout << i + 1;
                return;
            }
        }
        cout << 0;
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