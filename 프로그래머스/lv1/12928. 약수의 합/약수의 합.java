class Solution {
    public int solution(int n) {
        int acc = 0;
        for (int i = 1 ; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                acc += i;
                if (i != Math.sqrt(n)) {
                    acc += n / i;
                }
            }
        }
        return acc;
    }
}