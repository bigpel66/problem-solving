import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            int count = map.getOrDefault(participant[i], 0);
            map.put(participant[i], count + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            int count = map.get(completion[i]);
            if (count - 1 == 0) {
                map.remove(completion[i]);
            } else {
                map.replace(completion[i], count - 1);
            }
        }
        final String[] answer = new String[1];
        map.forEach((key, val) -> {
            answer[0] = key;
        });
        return answer[0];
    }
}