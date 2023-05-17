import java.util.stream.*;

class Solution {
    public long solution(int a, int b) {
        // return LongStream.range(a < b ? a : b, (a < b ? b : a) + 1).sum();
        
        // Sum of Arithmetic Sequence (Sn = numberOfTerm * (begin + end) / 2)
        return ((long) Math.abs(b - a) + 1) * (a + b) / 2;    
    }
}