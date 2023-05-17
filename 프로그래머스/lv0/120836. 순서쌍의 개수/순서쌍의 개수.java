class Solution {
    public int solution(int n) {
        int count = 0;
        int sqrt = (int) Math.sqrt(n);
        int completed = sqrt * sqrt == n ? 1 : 0;
        for (int i = 1 ; i < Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                count += 2;
            }
        }
        return count + completed;
    }
}