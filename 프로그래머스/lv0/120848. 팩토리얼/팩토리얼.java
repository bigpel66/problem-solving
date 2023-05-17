class Solution {
    public int solution(int n) {
        int[] memo = new int[11];
        memo[0] = memo[1] = 1;
        for (int i = 2 ; i <= 10; i++) {
            memo[i] = memo[i - 1] * i;
        }
        int left = 0;
        int right = 10;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (memo[mid] > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}