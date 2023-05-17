class Solution {
    public String[] solution(String my_str, int n) {
        String[] strings = new String[(int) Math.ceil((double) my_str.length() / n)];
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < my_str.length() ; i++) {
            if (i % n == 0) {
                sb = new StringBuilder();
            }
            sb.append(my_str.charAt(i));
            if (i == my_str.length() - 1 || i % n == n - 1) {
                strings[i / n] = sb.toString();
            }
        }
        return strings;
    }
}