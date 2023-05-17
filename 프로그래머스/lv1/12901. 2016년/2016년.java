import java.util.*;
import java.util.stream.*;

class Solution {
    static public List<Integer> counts = Arrays.asList(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    
    static public List<String> strings = Arrays.asList("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU");
    
    public String solution(int a, int b) {
        int sum = IntStream.range(0, a - 1).map(counts::get).sum();
        return strings.get((sum + b - 1) % 7);
    }
}