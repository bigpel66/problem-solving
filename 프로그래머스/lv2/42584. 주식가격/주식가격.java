import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            int diff = 0;
            for (int j = i + 1; j < prices.length; j++) {
                diff++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            list.add(diff);
        }
        return list.stream().mapToInt(e -> e).toArray();
    }
}