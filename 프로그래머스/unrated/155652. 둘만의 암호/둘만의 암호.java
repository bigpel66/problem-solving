import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> ignore = new HashSet<>();
        for (int i = 0 ; i < skip.length() ; i++) {
            ignore.add(skip.charAt(i));
        }
        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            int count = 0;
            int order = 1;
            while (true) {
                char next = (char) (((ch - 'a' + order++) % 26) + (int) 'a');
                if (!ignore.contains(next)) {
                    count++;
                }
                if (count == index) {
                    sb.append(next);
                    break;
                }
            }
        }
        return sb.toString();
    }
}