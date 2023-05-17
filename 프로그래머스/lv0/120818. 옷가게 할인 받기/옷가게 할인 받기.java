class Solution {
    
    static public int fivePercent = 100_000;
    
    static public int tenPercent = 300_000;
    
    static public int twentyPercent = 500_000;
    
    public int solution(int price) {
        if (price >= twentyPercent) {
            return price * 80 / 100;
        } else if (price >= tenPercent) {
            return price * 90 / 100;
        } else if (price >= fivePercent) {
            return price * 95 / 100;
        } else {
            return price;
        }
    }
}