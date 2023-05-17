import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1 ; i <= (int) Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }
        return list.stream().sorted().mapToInt(e -> e).toArray();
    }
}