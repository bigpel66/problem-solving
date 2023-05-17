#include <algorithm>
#include <climits>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_user;
    int number_of_edge;
    int min_sum;
    int answer;
    vector<vector<int>> matrix;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_user >> number_of_edge;
        matrix = vector<vector<int>>(number_of_user + 1, vector<int>(number_of_user + 1, INT_MAX/ 2));
        min_sum = INT_MAX;
        int x, y;
        for (int i = 1 ; i <= number_of_user ; i++) {
            matrix[i][i] = 0;
        }
        for (int i = 0 ; i < number_of_edge ; i++) {
            cin >> x >> y;
            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }
    }

    void solve(void) {
        for (int k = 1 ; k <= number_of_user ; k++) {
            for (int i = 1 ; i <= number_of_user ; i++) {
                for (int j = 1 ; j <= number_of_user ; j++) {
                    matrix[i][j] = min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 1 ; i <= number_of_user ; i++) {
            int sum = 0;
            for (int j = 1 ; j <= number_of_user ; j++) {
                sum += matrix[i][j];
            }
            if (min_sum > sum) {
                min_sum = sum;
                answer = i;
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