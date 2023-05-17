class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                char ch = 'a';
                if (Character.isUpperCase(s.charAt(i))) {
                    ch = 'A';
                }    
                sb.append((char) (((s.charAt(i) - ch + n) % 26) + ch));
            } else {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}