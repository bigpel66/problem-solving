import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers).map(e -> e * 2).toArray();
    }
}