import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        arr = Arrays.stream(arr).filter(e -> e != min).toArray();
        return arr.length == 0 ? new int[]{-1} : arr;
    }
}