class Solution {
    public String solution(String bin1, String bin2) {
        int v1 = Integer.parseInt(bin1, 2);
        int v2 = Integer.parseInt(bin2, 2);
        return Integer.toBinaryString(v1 + v2);
    }
}