#include <climits>
#include <cmath>
#include <vector>

using namespace std;

vector<vector<int>> generate(int rows, int columns) {
    vector<vector<int>> vec(rows, vector<int>(columns, 0));
    int count = 1;
    for (auto&& i : vec) {
        for (auto&& j : i) {
            j = count++;
        }
    }
    return vec;
}

int cw_rotate(vector<vector<int>>& matrix, vector<int>& query) {
    int rows = query.at(2) - query.at(0) + 1;
    int columns = query.at(3) - query.at(1) + 1;
    int x = query.at(0) - 1;
    int y = query.at(1) - 2;
    int inc = 1;
    int value = matrix.at(x + 1).at(y + 1);
    int result = value;
    int temp;
    rows--;
    for (int count = 0 ; rows >= 0 && columns >= 0 && count < 2 ; rows--, columns--, count++) {
        for (int i = 0 ; i < columns ; i++) {
            y += inc;
            temp = matrix.at(x).at(y);
            matrix[x][y] = value;
            value = temp;
            result = min(result, value);
        }
        for (int i = 0 ; i < rows ; i++) {
            x += inc;
            temp = matrix.at(x).at(y);
            matrix[x][y] = value;
            value = temp;
            result = min(result, value);
        }
        inc *= -1;
    }
    return result;
}

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    vector<vector<int>>&& matrix = generate(rows, columns);
    for (auto&& q : queries) {
        if (q.size() != 4) {
            continue;
        }
        answer.push_back(cw_rotate(matrix, q));
    }
    return answer;
}