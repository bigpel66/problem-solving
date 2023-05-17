import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Long> list = new ArrayList<>();
        while (true) {
            list.add(n % 10);
            n /= 10;
            if (n <= 0) {
                break;
            }
        }
        return list.stream().mapToInt(e -> Math.toIntExact(e)).toArray();
    }
}