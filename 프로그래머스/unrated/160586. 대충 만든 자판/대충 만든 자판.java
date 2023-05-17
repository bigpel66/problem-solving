import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < keymap.length ; i++) {
            for (int j = 0 ; j < keymap[i].length() ; j++) {
                map.put(keymap[i].charAt(j), Math.min(j + 1, map.getOrDefault(keymap[i].charAt(j), Integer.MAX_VALUE)));
            }
        }
        int[] answer = new int[targets.length];
        for (int i = 0 ; i < targets.length ; i++) {
            for (int j = 0 ; j < targets[i].length() ; j++) {
                if (!map.containsKey(targets[i].charAt(j))) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(targets[i].charAt(j));
            }
        }
        return answer;
    }
}