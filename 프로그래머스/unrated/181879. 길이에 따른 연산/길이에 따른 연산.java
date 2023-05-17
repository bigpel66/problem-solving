import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        if (num_list.length > 10) {
            return Arrays.stream(num_list).sum();
        } else {
            return Arrays.stream(num_list).reduce(1, (x, y) -> x * y);
        }
    }
}