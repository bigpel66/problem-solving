import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE;
        long start = times[0];
        long end = (long) times[times.length - 1] * n;
        while (start <= end) {
            long mid = (start + end) / 2;
            long peopleCount = 0;
            for (int t : times) {
                peopleCount += mid / t;
            }
            if (peopleCount >= n) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}