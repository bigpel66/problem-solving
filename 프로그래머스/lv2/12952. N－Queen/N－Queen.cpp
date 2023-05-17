#include <cmath>
#include <vector>

using namespace std;

bool is_crashed(int row, vector<int>& row_col) {
    for (int i = 0 ; i < row ; i++) {
        if (row_col[row] == row_col[i]) {
            return true;
        }
        if (row - i == abs(row_col[row] - row_col[i])) {
            return true;
        }
    }
    return false;
}

void dfs(int row, int n, int& answer, vector<int>& row_col) {
    if (row == n) {
        answer++;
        return;
    }
    for (int i = 0 ; i < n ; i++) {
        row_col[row] = i;
        if (!is_crashed(row, row_col)) {
            dfs(row + 1, n, answer, row_col);
        }
        row_col[row] = -1;
    }
}

int solution(int n) {
    int answer = 0;
    vector<int> row_col(n, -1);
    dfs(0, n, answer, row_col);
    return answer;
}