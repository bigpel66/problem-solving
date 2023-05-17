import java.util.*;

class Solution {
    public class Pair<T1 extends Comparable, T2 extends Comparable> implements Comparable<Pair<T1, T2>> {

        private T1 x;

        private T2 y;

        public Pair(T1 x, T2 y) {
            this.x = x;
            this.y = y;
        }

        public T1 getX() {
            return x;
        }

        public T2 getY() {
            return y;
        }

        @Override
        public int compareTo(Pair<T1, T2> o) {
            if (x.equals(o.getY())) {
                return y.compareTo(o.getY());
            }
            return x.compareTo(o.getX());
        }

    }
    
    public int solution(int[] priorities, int location) {
        int order = 0;
        Queue<Pair<Integer, Integer>> queue = generateQueue(priorities);
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            boolean isCirculated = false;
            for (Pair<Integer, Integer> p : queue) {
                if (poll.getX() < p.getX()) {
                    isCirculated = true;
                    break;
                }
            }
            if (isCirculated) {
                queue.offer(poll);
                continue;
            }
            order++;
            if (poll.getY() == location) {
                break;
            }
        }
        return order;
    }
    
    public Queue<Pair<Integer, Integer>> generateQueue(int[] priorities) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Pair<>(priorities[i], i));
        }
        return queue;
    }
}