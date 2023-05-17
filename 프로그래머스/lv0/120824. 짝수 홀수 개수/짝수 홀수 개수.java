import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        Arrays.stream(num_list).forEach(e -> {
            if (e % 2 == 0) {
                even.add(e);
            } else {
                odd.add(e);
            }
        });
        return new int[] { even.size(), odd.size() };
    }
}