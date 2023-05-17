class Solution {
    public int solution(int a, int d, boolean[] included) {
        int acc = 0;
        for (int i = 0 ; i < included.length ; i++) {
            int value = a + (d * i);
            if (included[i]) {
                acc += value;
            }
        }
        return acc;
    }
}