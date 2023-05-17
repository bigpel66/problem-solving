import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        arr = Arrays.stream(arr).sorted().filter(e -> e % divisor == 0).toArray();
        return arr.length == 0 ? new int[]{-1} : arr;
    }
}