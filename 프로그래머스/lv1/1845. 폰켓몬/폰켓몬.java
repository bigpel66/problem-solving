class Solution {
    public int solution(int[] nums) {
        boolean[] existence = new boolean[200001];
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!existence[nums[i]]) {
                answer++;
                existence[nums[i]] = true;
            }
        }
        return nums.length / 2 < answer ? nums.length / 2 : answer;
    }
}