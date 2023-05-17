import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> charSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < my_string.length() ; i++) {
            Character ch = my_string.charAt(i);
            if (!charSet.contains(ch)) {
                sb.append(ch.toString());
                charSet.add(ch);
            }
        }
        return sb.toString();
    }
}