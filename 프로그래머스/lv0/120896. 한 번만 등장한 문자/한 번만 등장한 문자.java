import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sb.append(entry.getKey().toString());
            }
        }
        char[] array = sb.toString().toCharArray(); 
        Arrays.sort(array);
        return new String(array);
    }
}