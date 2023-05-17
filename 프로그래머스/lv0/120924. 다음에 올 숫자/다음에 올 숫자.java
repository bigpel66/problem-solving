class Solution {
    public int solution(int[] common) {
        if (isArithmetic(common)) {
            return common[common.length - 1] + (common[1] - common[0]);
        } else {
            return common[common.length - 1] * (common[1] / common[0]);
        }
    }
    
    public boolean isArithmetic(int[] common) {
        return common[1] - common[0] == common[2] - common[1];
    }
}