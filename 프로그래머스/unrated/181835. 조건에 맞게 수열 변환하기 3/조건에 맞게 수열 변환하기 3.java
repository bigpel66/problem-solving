import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        if (k % 2 == 0) {
            return Arrays.stream(arr).map(e -> e + k).toArray();
        } else {
            return Arrays.stream(arr).map(e -> e * k).toArray();
        }
    }
}