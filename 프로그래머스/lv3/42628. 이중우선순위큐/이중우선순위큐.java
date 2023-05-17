import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    

    static private final String insertCommand = "I ";

    static private final String minPollCommand = "D -";
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].startsWith(insertCommand)) {
                int value = Integer.valueOf(operations[i].substring(operations[i].indexOf(' ') + 1));
                minPQ.offer(value);
                maxPQ.offer(value);
            } else if (operations[i].startsWith(minPollCommand)) {
                Integer value = minPQ.poll();
                if (value != null) {
                    maxPQ.removeIf(e -> e == value);
                }
            } else {
                Integer value = maxPQ.poll();
                if (value != null) {
                    minPQ.removeIf(e -> e == value);
                }
            }
        }
        if (minPQ.isEmpty() && maxPQ.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxPQ.poll(), minPQ.poll()};
        }
    }
}