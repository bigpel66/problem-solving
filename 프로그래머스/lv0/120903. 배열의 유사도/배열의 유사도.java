class Solution {
    public int solution(String[] s1, String[] s2) {
        int count = 0;
        for (String v1 : s1) {
            for (String v2 : s2) {
                if (v2.equals(v1)) {
                    count++;
                }
            }
        }
        return count;
    }
}