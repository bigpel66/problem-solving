import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int count = 0;
        while (true) {
            int[] copied = Arrays.copyOf(arr, arr.length);
            for (int i = 0 ; i < copied.length ; i++) {
                if (copied[i] >= 50 && copied[i] % 2 == 0) {
                    copied[i] /= 2;
                } else if (copied[i] < 50 && copied[i] % 2 == 1) {
                    copied[i] = copied[i] * 2 + 1;
                }
            }
            if (Arrays.equals(arr, copied)) {
                return count;
            }
            arr = copied;
            count++;
        }
    }
}