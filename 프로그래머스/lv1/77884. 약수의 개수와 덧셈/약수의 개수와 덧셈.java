import java.util.*;
import java.util.stream.*;

class Solution {
//     public int solution(int left, int right) {
//         return IntStream.range(left, right + 1).reduce(0, (x, y) -> {
//             int count = getNumberOfDivisor(y);
//             if (count % 2 == 1) {
//                 x -= y;
//             } else {
//                 x += y;
//             }
//             return x;
//         });
//     }
    
//     public int getNumberOfDivisor(int value) {
//         int count = 0;
//         for (int i = 1 ; i <= Math.sqrt(value) ; i++) {
//             if (value % i == 0) {
//                 count++;
//                 if (Math.pow(i, 2) != value) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
    
    public int solution(int left, int right) {
        return IntStream.range(left, right + 1).map(e -> {
            if (e % Math.sqrt(e) == 0) {
                return -e;
            } else {
                return e;
            }
        }).sum();
    }
}