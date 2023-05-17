import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = IntStream.rangeClosed(l, r).filter(i -> {
            String s = String.valueOf(i);
            s = s.replaceAll("[05]+", "");
            return s.isBlank();
        }).toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
}