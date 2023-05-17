import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array, int n) {
        return Arrays.stream(array).boxed().filter(e -> e == n).collect(Collectors.toList()).size();
    }
}