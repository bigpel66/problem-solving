import java.util.Arrays;

class Solution {
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0);
    }

    public int dfs(int[] numbers, int target, int index) {
        int answer = 0;
        if (index == numbers.length) {
            if (Arrays.stream(numbers).sum() == target) {
                return 1;
            } else {
                return 0;
            }
        }
        answer += dfs(numbers, target, index + 1);
        numbers[index] *= -1;
        answer += dfs(numbers, target, index + 1);
        return answer;
    }
}