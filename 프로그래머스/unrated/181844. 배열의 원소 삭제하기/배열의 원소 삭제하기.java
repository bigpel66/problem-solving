import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> set1 = new HashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        Set<Integer> set2 = new HashSet<>(Arrays.stream(delete_list).boxed().collect(Collectors.toList()));
        set1.removeAll(set2);
        return Arrays.stream(arr).filter(e -> set1.contains(e)).toArray();
    }
}