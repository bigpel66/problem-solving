class Solution {
    public int solution(int[] sides) {
        int minIndex = sides[0] < sides[1] ? 0 : 1;
        int maxIndex = sides[1] < sides[0] ? 0 : 1;
        int diff = sides[maxIndex] - sides[minIndex];
        return sides[0] + sides[1] - diff - 1;
    }
}