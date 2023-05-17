class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean isNew = true;
        for (int i = 0 ; i < sb.length() ; i++) {
            if (isNew) {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            } else {
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            }
            if (sb.charAt(i) == ' ') {
                isNew = true;
            } else {
                isNew = false;
            }
        }
        return sb.toString();
    }
}