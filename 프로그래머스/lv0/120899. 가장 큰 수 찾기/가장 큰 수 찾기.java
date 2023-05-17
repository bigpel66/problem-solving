import java.util.stream.*;

class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[]{Integer.MIN_VALUE, -1};
        // IntStream.range(0, array.length).forEachOrdered(n-> {
        //     if (array[n] > answer[0]) {
        //         answer[0] = array[n];
        //         answer[1] = n;
        //     }
        // });
        
        for (int n = 0 ; n < array.length ; n++) {
            if (array[n] > answer[0]) {
                answer[0] = array[n];
                answer[1] = n;
            }
        }
        return answer;
    }
}