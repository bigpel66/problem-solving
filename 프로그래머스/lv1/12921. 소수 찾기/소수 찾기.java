class Solution {
    public int solution(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = i * 2; j < n + 1; j += i) {
                isNotPrime[j] = true;
            }
        }
        int answer = 0;
        for (int i = 2; i < n + 1; i++) {
            if (!isNotPrime[i]) {
                answer++;
            }
        }
        return answer;
    }
}