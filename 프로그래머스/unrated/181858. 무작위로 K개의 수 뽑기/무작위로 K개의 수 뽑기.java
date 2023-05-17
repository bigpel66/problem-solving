import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        int[] answer = new int[k];
        Arrays.fill(answer, - 1);
        for (int i = 0 ; i < arr.length && k > 0 ; i++) {
            if (!set.contains(arr[i])) {
                answer[answer.length - k--] = arr[i];
                set.add(arr[i]);
            }
        }
        return answer;
    }
}