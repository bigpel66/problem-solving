import java.util.stream.*;

class Solution {
    public int solution(int n) {
        int answer = IntStream.range(2, n + 1).filter(e -> e % 2 == 0).sum();
        return answer;
    }
}