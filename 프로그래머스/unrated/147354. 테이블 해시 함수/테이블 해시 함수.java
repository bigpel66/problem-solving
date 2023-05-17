import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (v1, v2) -> v1[col - 1] == v2[col - 1] ? Integer.compare(v2[0], v1[0]) : Integer.compare(v1[col - 1], v2[col - 1]));
        for (int i = row_begin - 1 ; i <= row_end - 1 ; i++) {
            int acc = 0;
            for (int j = 0 ; j < data[0].length ; j++) {
                acc += data[i][j] % (i + 1);
            }
            answer = answer ^ acc;
        }
        return answer;
    }
}