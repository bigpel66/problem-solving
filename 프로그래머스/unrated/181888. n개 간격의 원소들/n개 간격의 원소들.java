class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[(num_list.length - 1) / n + 1];
        int index = 0;
        for (int i = 0 ; i < num_list.length ; i++) {
            if (i % n == 0) {
                answer[index++] = num_list[i];
            }
        }
        return answer;
    }
}