import java.util.regex.*;

class Solution {
    public String solution(String s) {
        Matcher m = Pattern.compile("[\\-0-9]+").matcher(s);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (m.find()) {
            int value = Integer.parseInt(m.group().toString());
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        return String.format("%d %d", min, max);
    }
}