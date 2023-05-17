import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int num, int total) {
        // for (int i = -100 ; i <= 100 ; i++) {
        //     int sum = 0;
        //     for (int j = i ; j < i + num ; j++) {
        //         sum += j;
        //     }
        //     if (sum == total) {
        //         return IntStream.range(i, i + num).toArray();
        //     }
        // }
        // return null;
        
        int middle = (int) Math.ceil((double) total / num);
        int start = middle - num / 2;
        return IntStream.range(start, start + num).toArray();
    }
}