import java.util.*;

public class Solution {
    public int solution(int n) {
        int acc = 0;
        while (true) {
            acc += n % 10;
            n /= 10;
            if (n == 0) {
                return acc;
            }
        }
    }
}