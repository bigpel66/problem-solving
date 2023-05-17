class Solution {
    public int solution(int[][] board, int k) {
        int acc = 0;
        for (int i = 0 ; i <= k ; i++) {
            for (int j = 0 ; j <= k ; j++) {
                if (i >= board.length || j >= board[0].length) {
                    continue;
                }
                if (i + j <= k) {
                    acc += board[i][j];
                }
            }
        }
        return acc;
    }
}