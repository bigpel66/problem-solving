import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum();
        int mult = Arrays.stream(num_list).reduce(1, (x, y) -> x * y);
        return Math.pow(sum, 2) > mult ? 1 : 0;
    }
}