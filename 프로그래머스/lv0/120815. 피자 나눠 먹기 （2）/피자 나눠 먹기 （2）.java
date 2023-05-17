class Solution {
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public int solution(int n) {
        int lcm = n * 6 / gcd(n, 6);
        return lcm / 6;
    }
}