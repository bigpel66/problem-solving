import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        return IntStream.range(0, queries.length).map(e -> IntStream.rangeClosed(queries[e][0], queries[e][1]).map(i -> arr[i]).filter(i -> i > queries[e][2]).min().orElse(-1)).toArray();
    }
}