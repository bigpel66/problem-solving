import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] beforeArr = before.toCharArray();
        char[] afterArr = after.toCharArray();
        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);
        boolean equals = Arrays.equals(beforeArr, afterArr);
        return equals ? 1 : 0;
    }
}