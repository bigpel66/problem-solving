import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, score.length).forEachOrdered(i -> {
            pq.offer(score[i]);
            if (i >= k) {
                pq.poll();
            }
            list.add(pq.peek());
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}