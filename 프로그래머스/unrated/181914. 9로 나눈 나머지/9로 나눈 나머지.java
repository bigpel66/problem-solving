class Solution {
    public int solution(String number) {
        int acc = 0;
        for (int i = 0 ; i < number.length() ; i++) {
            acc += number.charAt(i) - '0';
        }
        return acc % 9;
    }
}