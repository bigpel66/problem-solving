import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int weightSum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(truck_weights[i]);
                    weightSum += truck_weights[i];
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {
                    weightSum -= queue.poll();
                } else {
                    if (weightSum + truck_weights[i] > weight) {
                        queue.offer(0);
                        time++;
                    } else {
                        queue.offer(truck_weights[i]);
                        weightSum += truck_weights[i];
                        time++;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}