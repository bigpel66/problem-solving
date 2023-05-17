import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(e -> e.length()).toArray();
    }
}