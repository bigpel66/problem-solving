import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] index = IntStream.range(0, arr.length).filter(i -> arr[i] == 2).toArray();
        if (index.length == 0) {
            return new int[]{-1};
        } else {
            return Arrays.copyOfRange(arr, index[0], index[index.length - 1] + 1);
        }
    }
}