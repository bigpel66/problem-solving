class Solution {
    public boolean solution(String s) {
        // try {
        //     Integer.parseInt(s);
        //     return s.length() == 4 || s.length() == 6;
        // } catch (Exception e) {
        //     return false;
        // }
        return s.matches("^[0-9]{4}|^[0-9]{6}");
    }
}