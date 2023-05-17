class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            int col = i;
            int row = yellow / i;
            boolean isDividable = yellow % i == 0;
            if (!isDividable || col > row) {
                continue;
            }
            if (row * 2 + col * 2 + 4 == brown) {
                return new int[]{row + 2, col + 2};
            }
        }
        return new int[]{0, 0};
    }
}