class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int index = 0;
        for (int i = 0 ; i < section.length ; i++) {
            if (index < section[i]) {
                count++;
                index = section[i] + m - 1;
            }
        }
        return count;
    }
}