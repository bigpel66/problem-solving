import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n) {
        int[] isNotPrime = generateMatrix(n);
        return Arrays.stream(isNotPrime).sum();
    }
    
    public int[] generateMatrix(int n) {
        int[] matrix = new int[n + 1];
        matrix[0] = matrix[1] = 0;
        for (int i = 2 ; i <= (int) Math.sqrt(n) ; i++) {
            for (int j = i + i ; j < n + 1 ; j += i) {
                matrix[j] = 1;
            }
        }
        return matrix;
    }
}