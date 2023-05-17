class Solution {
    public int solution(int order) {
        int answer = 0;
        while (true) {
            int val = order % 10;
            order /= 10;
            if (val != 0 && val % 3 == 0) {
                answer++;
            }
            if (order == 0) {
                return answer;
            }
        }
    }
}