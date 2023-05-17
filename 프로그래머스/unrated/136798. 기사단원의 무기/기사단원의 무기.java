import java.util.*;

class Solution {
    public int getDivisorCount(int value) {
        int count = 0;
        for (int i = 1 ; i <= Math.sqrt(value) ; i++) {
            if (i * i == value) {
                count++;
            } else if (value % i == 0) {
                count += 2;
            }
        }
        return count;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1 ; i <= number ; i++) {
            int count = getDivisorCount(i);
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        return answer;
    }
}