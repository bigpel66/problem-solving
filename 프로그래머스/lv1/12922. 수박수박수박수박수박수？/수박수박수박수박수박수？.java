class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf("수박").repeat(n / 2));
        if (n % 2 == 1) {
            sb.append("수");
        }
        return sb.toString();
    }
}