class Solution {
    public int solution(int n) {
        int count = 0;
        while (true) {
            count += n % 10;
            n /= 10;
            if (n == 0) {
                break;
            }
        }
        return count;
    }
}