import java.util.*;

class Solution {
    public int[] solution(String s) {
        int stage = 0;
        int count = 0;
        while (true) {
            int zeros = countZeros(s);
            s = Integer.toBinaryString(s.length() - zeros);
            stage++;
            count += zeros;
            if (s.equals("1")) {
                break;
            }
        }
        return new int[]{stage, count};
    }
    
    public int countZeros(String s) {
        int count = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }
}