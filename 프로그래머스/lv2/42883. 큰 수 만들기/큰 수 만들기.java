class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        for (int restSize = number.length() - k - 1, startIndex = 0; restSize >= 0; restSize--) {
            int maxNumber = Integer.MIN_VALUE;
            for (int i = startIndex; i < number.length() - restSize; i++) {
                int digit = number.charAt(i) - '0';
                if (maxNumber < digit) {
                    maxNumber = digit;
                    startIndex = i + 1;
                }
            }
            sb.append(maxNumber);
        }
        return sb.toString();
    }
}