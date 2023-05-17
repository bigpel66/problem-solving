import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        boolean isDuplicated = false;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(array).forEach(e-> {
            map.put(e, map.getOrDefault(e, 0) + 1);
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                isDuplicated = true;
            }
            if (max < entry.getValue()) {
                answer = entry.getKey();
                isDuplicated = false;
                max = entry.getValue();
            }
        }
        return isDuplicated ? -1 : answer;
    }
}