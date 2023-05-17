class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isDigit(my_string.charAt(i))) {
                int acc = 0;
                while (i < my_string.length() && Character.isDigit(my_string.charAt(i))) {
                    acc = acc * 10 + Integer.parseInt(my_string.substring(i, i + 1));
                    i++;
                }
                answer += acc;
            }
        }
        return answer;
    }
}