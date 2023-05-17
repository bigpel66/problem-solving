import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int start, int end) {
        // return IntStream.range(end, start + 1).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        return IntStream.range(-start, -end + 1).map(e -> -e).toArray();
    }
}