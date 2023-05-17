import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int minusPossibility = numbers[0] * numbers[1];
        int plusPossibility = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        return Math.max(plusPossibility, minusPossibility);
    }
}