import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            for (int i = 2 ; i <= n ; i++) {
                if (n % i == 0) {
                    set.add(i);
                    n /= i;
                    break;
                }
            }
        }
        return set.stream().sorted().mapToInt(e -> e).toArray();
    }
}