import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = Arrays.stream(emergency).boxed().collect(Collectors.toList());
        list.sort(Comparator.reverseOrder());
        IntStream.range(0, emergency.length).forEachOrdered(n -> map.put(list.get(n), n));
        return Arrays.stream(emergency).map(e -> map.get(e) + 1).toArray();
    }
}