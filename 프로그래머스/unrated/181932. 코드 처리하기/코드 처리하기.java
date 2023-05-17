class Solution {
    public String solution(String code) {
        boolean isMode0 = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < code.length() ; i++) {
            if (code.charAt(i) == '1') {
                isMode0 = !isMode0;
                continue;
            }
            if (isMode0) {
                if (i % 2 == 0) {
                    sb.append(code.charAt(i));
                }
            } else {
                if (i % 2 == 1) {
                    sb.append(code.charAt(i));
                }
            }
        }
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}