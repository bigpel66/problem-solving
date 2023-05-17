class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string.substring(0, s));
        StringBuilder ot = new StringBuilder(my_string.substring(s, e + 1));
        sb.append(ot.reverse().toString());
        sb.append(my_string.substring(e + 1));
        return sb.toString();
    }
}