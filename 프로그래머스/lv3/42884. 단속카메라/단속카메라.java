import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (int[] v1, int[] v2) -> v1[1] - v2[1]);
        int count = 0;
        int camera = Integer.MIN_VALUE;
        for (int i = 0; i < routes.length; i++) {
            if (camera < routes[i][0]) {
                count++;
                camera = routes[i][1];
            }
        }
        return count;
    }
}