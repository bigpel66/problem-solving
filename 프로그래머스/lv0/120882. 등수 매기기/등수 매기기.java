import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[][] score) {
        List<Integer> sum = Arrays.stream(score).map(e -> Arrays.stream(e).sum()).collect(Collectors.toList());
        sum.sort(Comparator.reverseOrder());
        return Arrays.stream(score).mapToInt(e -> sum.indexOf(Arrays.stream(e).sum()) + 1).toArray();
    }
}