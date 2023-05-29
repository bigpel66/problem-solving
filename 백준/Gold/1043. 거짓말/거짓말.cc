#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_person;
    int number_of_party;
    int number_of_truth;
    vector<int> parent;
    vector<vector<int>> party;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_person >> number_of_party >> number_of_truth;
        parent = vector<int>(number_of_person + 1);
        for (size_t i = 0 ; i <= number_of_person ; i++) {
            parent[i] = i;
        }
        for (size_t i = 0 ; i < number_of_truth ; i++) {
            int temp;
            cin >> temp;
            parent[temp] = 0;
        }
    }

    int find_parent(int index) {
        if (parent.at(index) == index) {
            return index;
        }
        return parent[index] = find_parent(parent.at(index));
    }

    void union_parent(int v1, int v2) {
        v1 = find_parent(v1);
        v2 = find_parent(v2);
        if (v1 == v2) {
            return ;
        }
        if (v1 < v2) {
            parent[v2] = v1;
        } else {
            parent[v1] = v2;
        }
    }

    void solve(void) {
        int answer = number_of_party;
        for (size_t i = 0 ; i < number_of_party ; i++) {
            vector<int> temp;
            int number_of_participant, first_participant, other_participant;
            cin >> number_of_participant >> first_participant;
            temp.push_back(first_participant);
            for (int j = 1 ; j < number_of_participant ; j++) {
                cin >> other_participant;
                temp.push_back(other_participant);
                union_parent(first_participant, other_participant);
            }
            party.push_back(temp);
        }
        for (auto&& i : party) {
            for (auto&& j : i) {
                if (!find_parent(j)) {
                    answer--;
                    break;
                }
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