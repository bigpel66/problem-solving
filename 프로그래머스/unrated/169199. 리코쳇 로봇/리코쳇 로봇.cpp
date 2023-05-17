#include <climits>
#include <cmath>
#include <queue>
#include <string>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;

pair<point, point> find_point(const vector<string>& board) {
    point start, goal;
    for (int i = 0 ; i < board.size() ; i++) {
        for (int j = 0 ; j < board.at(i).length() ; j++) {
            if (board.at(i).at(j) == 'R') {
                start = point(i, j);
            }
            if (board.at(i).at(j) == 'G') {
                goal = point(i, j);
            }
        }
    }
    return pair<point, point>(start, goal);
}

int find_movement_count(point& start, point& goal, const vector<string>& board) {
    static vector<vector<int>> displacement{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    queue<point> q;
    vector<vector<int>> distance(board.size(), vector<int>(board.at(0).length(), INT_MAX));
    vector<vector<bool>> is_visited(board.size(), vector<bool>(board.at(0).length(), false));
    q.push({start.first, start.second});
    distance[start.first][start.second] = 0;
    is_visited[start.first][start.second] = true;
    while (!q.empty()) {
        point& p = q.front();
        q.pop();
        for (int i = 0 ; i < displacement.size() ; i++) {
            int next_x = p.first;
            int next_y = p.second;
            while (true) {
                next_x += displacement.at(i).at(0);
                next_y += displacement.at(i).at(1);
                if (next_x < 0 || next_y < 0 || next_x >= board.size() || next_y >= board.at(0).length() || board.at(next_x).at(next_y) == 'D') {
                    next_x -= displacement.at(i).at(0);
                    next_y -= displacement.at(i).at(1);
                    break;
                }
            }
            if (is_visited.at(next_x).at(next_y)) {
                continue;
            }
            distance[next_x][next_y] = distance[p.first][p.second] + 1;
            is_visited[next_x][next_y] = true;
            q.push({next_x, next_y});
        }
    }
    return distance[goal.first][goal.second] == INT_MAX ? -1 : distance[goal.first][goal.second];
}

int solution(vector<string> board) {
    pair<point, point>&& p = find_point(board);
    return find_movement_count(p.first, p.second, board);
}