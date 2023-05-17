import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < my_string.length() ; i++) {
            Character ch = my_string.charAt(i);
            if (Character.isDigit(ch)) {
                list.add(ch - '0');
            }
        }
        return list.stream().sorted().mapToInt(e -> e).toArray();
    }
}