class Solution {
    public int solution(int[] numbers, int n) {
        int acc = 0;
        int index = 0;
        while (index < numbers.length) {
            acc += numbers[index++];
            if (acc > n) {
                break;
            }
        }
        return acc;
    }
}