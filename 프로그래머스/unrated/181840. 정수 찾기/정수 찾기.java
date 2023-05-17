import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list, int n) {
        return Arrays.stream(num_list).filter(e -> e == n).boxed().collect(Collectors.toList()).size() == 0 ? 0 : 1;
    }
}