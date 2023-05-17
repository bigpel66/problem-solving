import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array) {
        int[] count = new int[1];
        Arrays.stream(array).forEach(e -> {
            char[] chars = String.valueOf(e).toCharArray();
            for (int i = 0 ; i < chars.length ; i++) {
                if (chars[i] == '7') {
                    count[0]++;
                }
            }
        });
        return count[0];
    }
}