import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        if (progresses.length == 0 && speeds.length == 0) {
            return new int[]{0};
        }
        List<Integer> list = new ArrayList<>() {{
            add(1);
        }};
        int requiredDays = calculateRequiredDays(progresses[0], speeds[0]);
        for (int i = 1; i < progresses.length; i++) {
            int newRequiredDays = calculateRequiredDays(progresses[i], speeds[i]);
            if (requiredDays >= newRequiredDays) {
                list.set(list.size() - 1, list.get(list.size() - 1) + 1);
            } else {
                list.add(1);
                requiredDays = newRequiredDays;            
            }
        }
        return list.stream().mapToInt(e -> e).toArray();
    }

    public int calculateRequiredDays(int progress, int speed) {
        return (int) Math.ceil((100 - progress) / (double) speed);    
    }
}