import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int[] min = dots[0];
        int[] max = dots[0];
        for (int i = 1 ; i < dots.length ; i++) {
            if (Arrays.compare(min, dots[i]) == 1) {
                min = dots[i];
            } 
            if (Arrays.compare(max, dots[i]) == -1) {
                max = dots[i];
            }
        }
        return (max[0] - min[0]) * (max[1] - min[1]);
    }
}