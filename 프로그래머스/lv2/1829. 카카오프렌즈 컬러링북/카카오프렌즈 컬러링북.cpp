#include <cmath>
#include <queue>
#include <vector>

using namespace std;
using point = pair<int, int>;

void bfs(int x, int y, int& number_of_area, int& max_size_of_one_area, vector<vector<bool>>& is_visited, const vector<vector<int>>& picture) {
    static const vector<vector<int>> displacement{{-1, 0}, {0, -1}, {0, 1}, {1,0 }};
    if (is_visited.at(x).at(y) || picture.at(x).at(y) == 0) {
        return;
    }
    int area = 1;
    int elem = picture.at(x).at(y);
    number_of_area++;
    is_visited[x][y] = true;
    queue<point> q;
    q.push({x, y});
    while (!q.empty()) {
        point& p = q.front();
        q.pop();
        for (int i = 0 ; i < displacement.size() ; i++) {
            int next_x = p.first + displacement.at(i).at(0);
            int next_y = p.second + displacement.at(i).at(1);
            if (next_x < 0 || next_y < 0 || next_x >= picture.size() || next_y >= picture.at(0).size() || is_visited.at(next_x).at(next_y) || picture.at(next_x).at(next_y) != elem) {
                continue;
            }
            area++;
            is_visited[next_x][next_y] = true;
            q.push({next_x, next_y});
        }
    }
    max_size_of_one_area = max(area, max_size_of_one_area);
}

vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    vector<vector<bool>> is_visited(m, vector<bool>(n, false));
    for (int i = 0 ; i < m ; i++) {
        for (int j = 0 ; j < n ; j++) {
            bfs(i, j, number_of_area, max_size_of_one_area, is_visited, picture);
        }
    }
    return vector<int>{number_of_area, max_size_of_one_area};
}