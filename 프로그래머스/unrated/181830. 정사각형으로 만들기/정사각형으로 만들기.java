import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;
        if (rowSize > colSize) {
            int[][] answer = new int[rowSize][rowSize];
            for (int i = 0 ; i < rowSize ; i++) {
                answer[i] = Arrays.copyOf(arr[i], rowSize);
            }
            return answer;
        } else {
            int[][] answer = new int[colSize][colSize];
            for (int i = 0 ; i < rowSize; i++) {
                answer[i] = arr[i];
            }
            return answer;
        }
    }
}