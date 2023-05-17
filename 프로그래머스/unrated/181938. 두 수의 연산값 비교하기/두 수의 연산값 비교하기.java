class Solution {
    public int solution(int a, int b) {
        int former = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int latter = 2 * a * b;
        return former > latter ? former : latter;
    }
}