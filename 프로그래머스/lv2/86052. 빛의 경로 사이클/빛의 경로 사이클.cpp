#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int calc_dir(int dir, char sign) {
    if (sign == 'L') {
        return (dir + 1) % 4;
    }
    return (dir + 3) % 4;
}

int dfs(int count, int x, int y, int dir, vector<vector<vector<bool>>>& is_visited, const vector<string>& grid) {
    static const vector<vector<int>> displacement{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    if (is_visited.at(x).at(y).at(dir)) {
        return count;
    }
    is_visited[x][y][dir] = true;
    if (grid.at(x).at(y) != 'S') {
        dir = calc_dir(dir, grid.at(x).at(y));
    }
    int next_x = x + displacement.at(dir).at(0);
    int next_y = y + displacement.at(dir).at(1);
    if (next_x < 0) {
        next_x = grid.size() - 1;
    } else if (next_x >= grid.size()) {
        next_x = 0;
    }
    if (next_y < 0) {
        next_y = grid.at(0).length() - 1;
    } else if (next_y >= grid.at(0).length()) {
        next_y = 0;
    }
    return dfs(count + 1, next_x, next_y, dir, is_visited, grid);
}

vector<int> solution(vector<string> grid) {
    vector<int> answer;
    vector<vector<vector<bool>>> is_visited(grid.size(), vector<vector<bool>>(grid.at(0).length(), vector<bool>(4, false)));
    for (int i = 0 ; i < grid.size() ; i++) {
        for (int j = 0 ; j < grid.at(i).length() ; j++) {
            for (int k = 0 ; k < 4 ; k++) {
                int step = dfs(0, i, j, k, is_visited, grid);
                if (step) {
                    answer.push_back(step);
                }
            }
        }
    }
    sort(answer.begin(), answer.end(), less<int>());
    return answer;
}