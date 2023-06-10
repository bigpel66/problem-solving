#include <algorithm>
#include <cmath>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using coord = pair<double, double>;
using point = pair<int, int>;
using kruskal = pair<double, point>;

class sol {
private:
    double answer;
    int number_of_star;
    vector<int> parent;
    vector<coord> star;
    vector<kruskal> matrix;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        answer = 0.0;
        cin >> number_of_star;
        parent = vector<int>(number_of_star);
        star = vector<coord>(number_of_star);
        for (int i = 0 ; i < number_of_star ; i++) {
            parent[i] = i;
            cin >> star[i].first >> star[i].second;
        }
    }

    double get_star_distance(int i, int j) {
        const coord& c1 = star.at(i);
        const coord& c2 = star.at(j);
        return sqrt(pow((c1.first - c2.first), 2) + pow((c1.second - c2.second), 2));
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
        for (int i = 0 ; i < number_of_star - 1 ; i++) {
            for (int j = i + 1 ; j < number_of_star ; j++) {
                double dist = get_star_distance(i, j);
                matrix.push_back({dist, {i, j}});
            }
        }
        sort(matrix.begin(), matrix.end(), less<>());
        for (size_t i = 0 ; i < matrix.size() ; i++) {
            const double& distance = matrix.at(i).first;
            const int& from = matrix.at(i).second.first;
            const int& to = matrix.at(i).second.second;
            if (!is_same_parent(from, to)) {
                union_parent(from, to);
                answer += distance;
            }
        }
        cout.precision(2);
        cout << fixed << answer;
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