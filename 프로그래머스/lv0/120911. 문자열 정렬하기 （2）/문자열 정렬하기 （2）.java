import java.util.*;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] charArr = my_string.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}