#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_gate, number_of_airplane;
    vector<int> parent;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_gate >> number_of_airplane;
        parent = vector<int>(number_of_gate + 1, 0);
        for (int i = 1 ; i <= number_of_gate ; i++) {
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

    void solve(void) {
        int preferred_gate;
        for (int i = 0 ; i < number_of_airplane ; i++) {
            cin >> preferred_gate;
            preferred_gate = find_parent(preferred_gate);
            if (!preferred_gate) {
                cout << i;
                return;
            }
            union_parent(preferred_gate, preferred_gate - 1);
        }
        cout << number_of_airplane;
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