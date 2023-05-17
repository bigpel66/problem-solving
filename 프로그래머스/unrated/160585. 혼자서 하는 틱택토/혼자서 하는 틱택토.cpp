#include <string>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;
using points = vector<point>;
using marks = pair<points, points>;

marks find_marks(const vector<string>& board) {
    points o_points;
    points x_points;
    for (int i = 0 ; i < board.size() ; i++) {
        for (int j = 0 ; j < board.at(i).length() ; j++) {
            if (board.at(i).at(j) == 'O') {
                o_points.push_back({i, j});
            } else if (board.at(i).at(j) == 'X') {
                x_points.push_back({i, j});
            }
        }
    }
    return marks(o_points, x_points);
}

bool is_win(const point& p, const vector<string>& board) {
    int x1 = p.first;
    int y1 = p.second;
    int x2 = (p.first + 1) % 3;
    int y2 = (p.second + 1) % 3;
    int x3 = (p.first + 2) % 3;
    int y3 = (p.second + 2) % 3;
    if (board[x1][y1] == board[x2][y1] && board[x2][y1] == board[x3][y1] && board[x3][y1] == board[x1][y1]) {
        return true;
    }
    if (board[x1][y1] == board[x1][y2] && board[x1][y2] == board[x1][y3] && board[x1][y3] == board[x1][y1]) {
        return true;
    }
    if ((board[x1][y1] == board[x2][y2] && board[x2][y2] == board[x3][y3] && board[x3][y3] == board[x1][y1]) || (board[x1][y1] == board[x2][y3] && board[x2][y3] == board[x3][y2] && board[x3][y2] == board[x1][y1])) {
        return true;
    }
    return false;
}

int is_valid(const marks& m, const vector<string>& board) {
    const points& o_points = m.first;
    const points& x_points = m.second;
    int diff = o_points.size() - x_points.size();
    if (diff < 0 || diff > 1) {
        return 0;
    }
    for (auto&& o : o_points) {
        if (is_win(o, board) && diff != 1) {
            return 0;
        }
    }
    for (auto&& x : x_points) {
        if (is_win(x, board) && diff != 0) {
            return 0;
        }
    }
    return 1;
}

int solution(vector<string> board) {
    marks&& m = find_marks(board);
    return is_valid(m, board);
}