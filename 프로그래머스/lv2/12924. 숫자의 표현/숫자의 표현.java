class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1 ; i <= n ; i++) {
            int acc = 0;
            for (int j = i ; j <= n ; j++) {
                acc += j;
                if (acc >= n) {
                    break;
                }
            }
            if (acc == n) {
                answer++;
            }
        }
        return answer;
    }
}