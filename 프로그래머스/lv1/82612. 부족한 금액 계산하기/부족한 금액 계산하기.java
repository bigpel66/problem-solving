class Solution {
    public long solution(int price, int money, int count) {
        long remain = count * (price + (long) price * count) / 2 - money;
        return remain <= 0 ? 0 : remain;
    }
}