import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, (v1, v2) -> Character.compare(v1.charAt(n), v2.charAt(n)));
        return strings;
    }
}