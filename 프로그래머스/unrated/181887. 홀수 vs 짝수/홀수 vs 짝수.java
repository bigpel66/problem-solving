class Solution {
    public int solution(int[] num_list) {
        int acc1 = 0;
        int acc2 = 0;
        for (int i = 0 ; i < num_list.length ; i++) {
            if (i % 2 == 0) {
                acc1 += num_list[i];
            } else {
                acc2 += num_list[i];
            }
        }
        return acc1 > acc2 ? acc1 : acc2;
    }
}