class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int index = 0;
        while (true) {
            answer++;
            if (answer == k) {
                return numbers[index];
            }
            index = (index + 2) % numbers.length;
        }
    }
}