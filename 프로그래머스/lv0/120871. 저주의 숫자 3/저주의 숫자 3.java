class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1 ; i <= n ; i++) {
            count++;
            while (count % 3 == 0 || String.valueOf(count).contains("3")) {
                count++;
            }
        }
        return count;
    }
}