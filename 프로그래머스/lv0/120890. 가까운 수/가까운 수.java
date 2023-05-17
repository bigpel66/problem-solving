import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array, int n) {
        int[] answer = new int[1];
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        Arrays.sort(array);
        Arrays.stream(array).forEach(e -> {
            int diff = Math.abs(e - n);
            if (min[0] > diff) {
                min[0] = diff;
                answer[0] = e;
            }
        });
        return answer[0];
    }
}