import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < intervals.length ; i++) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            for (int j = begin; j <= end ; j++) {
                list.add(arr[j]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}