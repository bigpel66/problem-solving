class Solution {
    public int solution(int[] a, int[] b) {
        int acc = 0;
        for (int i = 0 ; i < a.length ; i++) {
            acc += a[i] * b[i];
        }
        return acc;
    }
}