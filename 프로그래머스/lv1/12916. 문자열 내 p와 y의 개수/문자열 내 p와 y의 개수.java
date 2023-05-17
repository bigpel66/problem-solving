class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int pCount = 0;
        int yCount = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (ch == 'p') {
                pCount++;
            } else if (ch == 'y') {
                yCount++;
            }
        }
        return pCount == yCount;
    }
}