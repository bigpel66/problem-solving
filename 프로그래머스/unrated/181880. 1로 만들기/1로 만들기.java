class Solution {
    public int solution(int[] num_list) {        
        int acc = 0;
        for (int i = 0 ; i < num_list.length ; i++) {
            int value = num_list[i];
            int count = 0;
            while (value != 1) {
                if (value % 2 == 0) {
                    value /= 2;
                } else {
                    value = (value - 1) / 2;
                }
                count++;
                if (value == 1) {
                    break;
                }
            }
            acc += count;
        }
        return acc;
    }
}