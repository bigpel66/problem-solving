import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] points = new int[201];
        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0]; j < lines[i][1]; j++) {
                points[j + 100]++;
            }
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] >= 2) {
                answer++;
            }
        }
        return answer;
    }
}