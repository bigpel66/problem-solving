import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        List<Integer> list = generateEmptySeries();
        Arrays.stream(numbers).forEach(e -> {
            list.removeIf(l -> l == e);
        });
        return list.stream().mapToInt(e -> e).sum();
    }
    
     static public List<Integer> generateEmptySeries() {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 10).forEach(n -> list.add(n));
        return list;
    }
}