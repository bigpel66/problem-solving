class Solution {
    public int solution(int num) {
        if (num == 1) {
            return 0;
        }
        int answer = 0;
        while (answer < 500) {
            if (num % 2 == 1) {
                num = num * 3 + 1;
            } else {
                num /= 2;
            }
            answer++;
            if (num == 1) {
                return answer;
            }
        }
        return -1;
    }
}