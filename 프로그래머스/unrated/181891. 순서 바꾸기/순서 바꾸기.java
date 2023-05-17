class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] arr = new int[num_list.length];
        for (int i = n ; i < num_list.length ; i++) {
            arr[i - n] = num_list[i];
        }
        for (int i = 0 ; i < n ; i++) {
            arr[num_list.length - n + i] = num_list[i];
        }
        
        return arr;
    }
}