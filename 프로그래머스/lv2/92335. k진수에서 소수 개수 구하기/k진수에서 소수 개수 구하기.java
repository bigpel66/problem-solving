import java.util.regex.*;

class Solution {
    public int solution(int n, int k) {
        Matcher m = Pattern.compile("[^0]+").matcher(Integer.toString(n, k));
        int count = 0;
        while (m.find()) {
            if (isPrime(Long.parseLong(m.group().toString()))) {
                count++;
            }
        }
        return count;
    }
    
    public boolean isPrime(long value) {
        if (value == 0 || value == 1) {
            return false;
        }
        for (int i = 2 ; i <= Math.sqrt(value) ; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}