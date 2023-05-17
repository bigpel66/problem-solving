import java.util.*;

class Solution {    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public Set<Integer> getPrimeFactors(int value) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            for (int i = 2 ; i <= value ; i++) {
                if (value % i == 0) {
                    set.add(i);
                    value /= i;
                    break;
                }
            }
            if (value == 1) {
                return set;
            }
        }
        
    }
    
    public int solution(int a, int b) {
        int common = gcd(a, b);
        int denom = b / common;
        Set<Integer> primeFactors = getPrimeFactors(denom);
        primeFactors.remove(2);
        primeFactors.remove(5);
        return primeFactors.size() > 0 ? 2 : 1;
    }
}