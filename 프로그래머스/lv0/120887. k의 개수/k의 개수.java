import java.util.stream.*;

class Solution {
    public int solution(int i, int j, int k) {
        int[] answer = new int[1];
        IntStream.range(i, j + 1).forEachOrdered(n -> {
            String s = String.valueOf(n);
            for (int l = 0 ; l < s.length() ; l++) {
                if (s.charAt(l) - '0' == k) {
                    answer[0]++;
                }
            }
        });
        return answer[0];
    }
}