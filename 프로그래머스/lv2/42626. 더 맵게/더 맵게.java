import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        List<Integer> list = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.addAll(list);
        int count = 0;
        while (true) {
            boolean allMatch = pq.stream().allMatch(e -> e >= K);
            if (allMatch) {
                break;
            }
            Integer first = pq.poll();
            Integer second = pq.poll();
            if (first == null || second == null) {
                return -1;
            }
            pq.offer(first + 2 * second);
            count++;
        }
        return count;
    }
}