import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];
        IntStream.range(0, n).forEachOrdered(i -> answer[i] = num_list[i]);
        return answer;
    }
}