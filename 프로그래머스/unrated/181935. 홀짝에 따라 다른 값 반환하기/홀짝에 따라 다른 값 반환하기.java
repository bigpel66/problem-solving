import java.util.stream.*;

class Solution {
    public int solution(int n) {
        if (n % 2 == 0) {
            return IntStream.range(1, n + 1).filter(e -> e % 2 == 0).map(e -> (int) Math.pow(e, 2)).sum();
        } else {
            return IntStream.range(1, n + 1).filter(e -> e % 2 == 1).sum();
        }
    }
}