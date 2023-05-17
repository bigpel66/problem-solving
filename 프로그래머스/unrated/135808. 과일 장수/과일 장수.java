import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int sum = 0;
        for (int i = score.length ; i - m >= 0 ; i -= m) {
            sum += score[i - m] * m;
        }
        return sum;
    }
}