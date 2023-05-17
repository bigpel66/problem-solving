class Solution {
    public int solution(int n) {
       String s = "";
        while (n > 0) {
            Integer i = n % 3;
            s += i.toString();
            n /= 3;
        }
        int answer = 0;
        int mult = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            answer += (s.charAt(i) - '0') * mult;
            mult *= 3;
        }
        return answer;
    }
}