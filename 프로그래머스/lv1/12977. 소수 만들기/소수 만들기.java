class Solution {    
    static public final boolean[] isNotPrime = generatePrimeMap(3001);
    
    public int solution(int[] nums) {
        int count = 0;
        for (int i = 0 ; i < nums.length - 2 ; i++) {
            for (int j = i + 1 ; j < nums.length - 1 ; j++) {
                for (int k = j + 1 ; k < nums.length ; k++) {
                    if (!isNotPrime[nums[i] + nums[j] + nums[k]]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    static public boolean[] generatePrimeMap(int size) {
        boolean[] arr = new boolean[size];
        arr[0] = arr[1] = true;
        for (int i = 2 ; i <= Math.sqrt(size - 1) ; i++) {
            for (int j = i * 2 ; j <= size - 1 ; j += i) {
                arr[j] = true;
            }
        }
        return arr;
    }
}