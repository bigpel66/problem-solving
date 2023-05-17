#include <string>
#include <vector>

using namespace std;

bool is_valid(int count, int x, int y, vector<vector<int>>& displacement, vector<vector<bool>>& is_visited, vector<string>& seats) {
    if (count == 2) {
        return seats.at(x).at(y) != 'P';
    }
    is_visited[x][y] = true;
    for (int i = 0 ; i < displacement.size() ; i++) {
        int nextX = x + displacement.at(i).at(0);
        int nextY = y + displacement.at(i).at(1);
        if (nextX < 0 || nextY < 0 || nextX >= seats.size() || nextY >= seats.at(0).length() || is_visited[nextX][nextY] || seats.at(nextX).at(nextY) == 'X') {
            continue;
        }
        if (seats.at(nextX).at(nextY) == 'P'|| !is_valid(count + 1, nextX, nextY, displacement, is_visited, seats)) {
            return false;
        }
    }
    is_visited[x][y] = false;
    return true;
}

bool is_districted(vector<vector<int>>& displacement, vector<string>& seats) {
    vector<vector<bool>> is_visited(seats.size(), vector<bool>(seats.at(0).length(), false));
    for (int i = 0 ; i < seats.size() ; i++) {
        for (int j = 0 ; j < seats.at(i).length() ; j++) {
            if (seats.at(i).at(j) == 'P' && !is_valid(0, i, j, displacement, is_visited, seats)) {
                return false;
            }
        }
    }
    return true;
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    vector<vector<int>> displacement{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    for (auto&& i : places) {
        answer.push_back(is_districted(displacement, i));
    }
    return answer;
}