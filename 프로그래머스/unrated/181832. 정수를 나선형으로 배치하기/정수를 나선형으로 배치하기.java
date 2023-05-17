class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int row = 0;
        int col = -1;
        int inc = 1;
        int value = 1;
        while (true) {
            for (int i = 0 ; i < n ; i++) {
                col += inc;
                answer[row][col] = value++;
            }
            n--;
            if (n == 0) {
                break;
            }
            for (int i = 0 ; i < n ; i++) {
                row += inc;
                answer[row][col] = value++;
            }
            inc *= -1;
        }
        return answer;
    }
}