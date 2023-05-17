import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arr, int idx) {
        // String s = Arrays.stream(arr).boxed().map(e -> e.toString()).collect(Collectors.joining(""));
        // return s.indexOf(String.valueOf(1), idx);
        return IntStream.range(idx, arr.length).filter(i -> arr[i] == 1).findFirst().orElse(-1);
    }
}