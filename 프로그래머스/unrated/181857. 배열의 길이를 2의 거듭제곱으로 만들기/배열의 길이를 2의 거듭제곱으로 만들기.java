import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        double log = Math.log(arr.length) / Math.log(2);
        return Arrays.copyOf(arr, (int) Math.pow(2, (int) Math.ceil(log)));
    }
}