class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public int[] solution(int n, int m) {
        int common = gcd(n , m);
        return new int[]{common, n * m / common};
    }
}