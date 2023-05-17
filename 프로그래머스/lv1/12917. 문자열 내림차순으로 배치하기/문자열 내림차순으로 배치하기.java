import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        // StringBuilder sb = new StringBuilder();
        // s.chars().mapToObj(i -> (char) i).sorted(Comparator.reverseOrder()).forEach(i -> sb.append(i));
        // return sb.toString();
        
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        sb.append(new String(chars));
        return sb.reverse().toString();
    }
}