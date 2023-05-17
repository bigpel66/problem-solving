import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] arr = new int[num_list.length / n][n];
        IntStream.range(0, num_list.length).forEachOrdered(i -> {
            arr[i / n][i % n] = num_list[i];
        });
        return arr;
    }
}