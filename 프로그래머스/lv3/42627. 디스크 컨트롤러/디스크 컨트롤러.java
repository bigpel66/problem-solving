import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(t -> t[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t[1]));
        int accumulation = 0;
        int completedJobCount = 0;
        int scheduledCount = 0;
        int currentTimestamp = 0;
        while (completedJobCount < jobs.length) {
            while (scheduledCount < jobs.length && jobs[scheduledCount][0] <= currentTimestamp) {
                pq.add(jobs[scheduledCount++]);
            }
            if (pq.isEmpty()) {
                currentTimestamp = jobs[scheduledCount][0];
            } else {
                int[] poll = pq.poll();
                accumulation += poll[1] + currentTimestamp - poll[0];
                currentTimestamp += poll[1];
                completedJobCount++;
            }
        }
        return accumulation / jobs.length;
    }
}