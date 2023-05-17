#include <climits>
#include <cmath>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board)
{
    int row = board.size();
    int col = board.at(0).size();
    int value = INT_MIN;
    for (int i = 1 ; i < row ; i++) {
        for (int j = 1 ; j < col ; j++) {
            if (board[i][j] == 0) {
                continue;
            }
            board[i][j] = min(board.at(i - 1).at(j - 1), min(board.at(i - 1).at(j), board.at(i).at(j - 1))) + 1;
            value = max(value, board[i][j]);
        }
    }
    for (int i = 0 ; i < row ; i++) {
        value = max(value, board.at(i).at(0));
    }
    for (int i = 0 ; i < col ; i++) {
        value = max(value, board.at(0).at(i));
    }
    return value * value;
}