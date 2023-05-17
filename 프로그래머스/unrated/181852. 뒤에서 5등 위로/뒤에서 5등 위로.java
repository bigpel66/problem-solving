import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return IntStream.range(5, num_list.length).map(i -> num_list[i]).toArray();
    }
}