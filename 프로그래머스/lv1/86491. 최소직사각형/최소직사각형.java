class Solution {
    public int solution(int[][] sizes) {
        int row = Integer.MIN_VALUE;
        int col = Integer.MIN_VALUE;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                row = row < sizes[i][1] ? sizes[i][1] : row;
                col = col < sizes[i][0] ? sizes[i][0] : col;
            } else {
                row = row < sizes[i][0] ? sizes[i][0] : row;
                col = col < sizes[i][1] ? sizes[i][1] : col;
            }
        }
        return row * col;
    }
}