import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(1, n + 1).filter(e -> e % 2 == 1).forEachOrdered(e -> list.add(e));
        return list.stream().mapToInt(e -> e).toArray();
    }
}