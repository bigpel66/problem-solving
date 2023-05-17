#include <vector>

using namespace std;

void dfs(int n, int begin, int mid, int end, vector<vector<int>>& answer) {
    if (n == 0) {
        return;
    }
    dfs(n - 1, begin, end, mid, answer);
    answer.push_back({begin, end});
    dfs(n - 1, mid, begin, end, answer);
}

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    dfs(n, 1, 2, 3, answer);
    return answer;
}