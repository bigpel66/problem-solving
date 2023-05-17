class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < my_string.length() ; i++) {
            Character ch = my_string.charAt(i);
            if (Character.isUpperCase(ch)) {
                sb.append(ch.toString().toLowerCase());
            } else {
                sb.append(ch.toString().toUpperCase());
            }
        }
        return sb.toString();
    }
}