#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_city;
    int number_of_road;
    vector<vector<int>> matrix;

    static const int& MAX;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_city >> number_of_road;
        matrix = vector<vector<int>>(number_of_city + 1, vector<int>(number_of_city + 1, MAX));
        int from, to, cost;
        for (int i = 0 ; i < number_of_road ; i++) {
            cin >> from >> to >> cost;
            matrix[from][to] = min(matrix.at(from).at(to), cost);
        }
    }

    void solve(void) {
        for (int k = 1 ; k <= number_of_city ; k++) {
            for (int i = 1 ; i <= number_of_city ; i++) {
                for (int j = 1 ; j <= number_of_city ; j++) {
                    matrix[i][j] = min(matrix.at(i).at(j), matrix.at(i).at(k) + matrix.at(k).at(j));
                }
            }
        }
        for (int i = 1 ; i <= number_of_city ; i++) {
            for (int j = 1 ; j <= number_of_city ; j++) {
                if (i == j || matrix.at(i).at(j) >= MAX) {
                    cout << 0 << ' ';
                } else {
                    cout << matrix.at(i).at(j) << ' ';
                }
            }
            cout << '\n';
        }
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

const int& sol::MAX = 10'000'000;

int main(void) {
    sol ve;
    return 0;
}