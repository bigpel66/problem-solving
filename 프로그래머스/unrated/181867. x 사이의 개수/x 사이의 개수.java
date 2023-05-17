import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] split = myString.split("x");
        List<Integer> list = new ArrayList<>();
        Arrays.stream(split).forEach(e -> list.add(e.length()));
        if (myString.charAt(myString.length() - 1) == 'x') {   
            list.add(0);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}