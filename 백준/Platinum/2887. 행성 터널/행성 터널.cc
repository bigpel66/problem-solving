#include <algorithm>
#include <cmath>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using planet = pair<int, int>;
using edge = pair<int, int>;
using tunnel = pair<int, edge>;

class sol {
private:
    int number_of_planet, answer;
    vector<planet> x;
    vector<planet> y;
    vector<planet> z;
    vector<tunnel> k;
    vector<int> parent;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_planet;
        answer = 0;
        x = vector<planet>(number_of_planet);
        y = vector<planet>(number_of_planet);
        z = vector<planet>(number_of_planet);
        parent = vector<int>(number_of_planet);
        for (int i = 0 ; i < number_of_planet ; i++) {
            parent[i] = i;
            cin >> x[i].first >> y[i].first >> z[i].first;
            x[i].second = y[i].second = z[i].second = i;
        }
        sort(x.begin(), x.end(), less<>());
        sort(y.begin(), y.end(), less<>());
        sort(z.begin(), z.end(), less<>());
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
        for (int i = 0 ; i < number_of_planet - 1 ; i++) {
            k.push_back({abs(x.at(i).first - x.at(i + 1).first), {x.at(i).second, x.at(i + 1).second}});
            k.push_back({abs(y.at(i).first - y.at(i + 1).first), {y.at(i).second, y.at(i + 1).second}});
            k.push_back({abs(z.at(i).first - z.at(i + 1).first), {z.at(i).second, z.at(i + 1).second}});
        }
        sort(k.begin(), k.end(), less<>());
        for (size_t i = 0 ; i < k.size() ; i++) {
            const int& distance = k.at(i).first;
            const int& planet_1_index = k.at(i).second.first;
            const int& planet_2_index = k.at(i).second.second;
            if (!is_same_parent(planet_1_index, planet_2_index)) {
                union_parent(planet_1_index, planet_2_index);
                answer += distance;
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