import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        // Map<Integer, List<Integer>> map = IntStream.range(0, numlist.length).boxed().collect(Collectors.toMap(
        //     i -> Math.abs(n - numlist[i]), 
        //     i -> new ArrayList<>(Arrays.asList(numlist[i])),
        //     (x, y) -> { 
        //         x.addAll(y);
        //         return x; 
        //     }
        // ));
        // List<Integer> answer = new ArrayList<>();
        // map.keySet().stream().sorted().forEach(key -> {
        //     List<Integer> sublist = map.get(key);
        //     sublist.sort(Comparator.reverseOrder());
        //     answer.addAll(sublist);
        // });
        // return answer.stream().mapToInt(v -> v).toArray();
        return Arrays.stream(numlist).boxed().sorted((v1, v2) -> {
            return Math.abs(v1 - n) == Math.abs(v2 - n)
                ? Integer.compare(v2, v1)
                : Integer.compare(Math.abs(v1 - n), Math.abs(v2 - n));
        }).mapToInt(e -> e).toArray();
    }
}