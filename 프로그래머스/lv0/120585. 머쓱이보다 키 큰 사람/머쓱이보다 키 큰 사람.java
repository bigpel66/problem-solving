import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array, int height) {
        return Arrays.stream(array).boxed().filter(e -> e > height).collect(Collectors.toList()).size();
    }
}