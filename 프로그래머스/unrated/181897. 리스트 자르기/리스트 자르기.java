import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        if (n == 1) {
          return Arrays.copyOfRange(num_list, 0, slicer[1] + 1);
        } else if (n == 2) {
            return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
        } else if (n == 3) {
            return Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
        } else {
            return IntStream.range(slicer[0], slicer[1] + 1).filter(i -> (i - slicer[0]) % slicer[2] == 0).map(i -> num_list[i]).toArray();
        }
    }
}