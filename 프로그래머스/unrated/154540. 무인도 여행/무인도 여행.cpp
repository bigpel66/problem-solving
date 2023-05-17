#include <algorithm>
#include <string>
#include <vector>

using namespace std;

void dfs(int& acc, int x, int y, vector<vector<int>>& displacement, vector<vector<bool>>& is_visited, vector<string>& maps) {
    if (maps.at(x).at(y) == 'X' || is_visited[x][y]) {
        return;
    }
    is_visited[x][y] = true;
    acc += maps.at(x).at(y) - '0';
    for (int i = 0 ; i < displacement.size() ; i++) {
        int nextX = x + displacement.at(i).at(0);
        int nextY = y + displacement.at(i).at(1);
        if (nextX < 0 || nextY < 0 || nextX >= is_visited.size() || nextY >= is_visited.at(0).size() || is_visited[nextX][nextY]) {
            continue;
        }
        dfs(acc, nextX, nextY, displacement, is_visited, maps);
    }
}

vector<int> solution(vector<string> maps) {
    vector<int> answer;
    vector<vector<int>> displacement{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    vector<vector<bool>> is_visited(maps.size(), vector<bool>(maps.at(0).length(), false));
    for (int i = 0 ; i < is_visited.size() ; i++) {
        for (int j = 0 ; j < is_visited.at(0).size() ; j++) {
            int area = 0;
            dfs(area, i, j, displacement, is_visited, maps);
            if (area) {
                answer.push_back(area);
            }
        }
    }
    sort(answer.begin(), answer.end(), less<int>());
    return answer.size() == 0 ? vector<int>{-1} : answer;
}