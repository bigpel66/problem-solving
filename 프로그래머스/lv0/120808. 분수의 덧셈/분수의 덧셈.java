class Solution {
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int newDenom = denom1 * denom2;
        int newNumer = numer1 * denom2 + numer2 * denom1;
        int common = gcd(newNumer, newDenom);
        return new int[]{newNumer / common, newDenom / common};
    }
}