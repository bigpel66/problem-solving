class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
 int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int or = arr1[i] | arr2[i];
            result[i] = or;
        }
        String[] returnArr = new String[n];
        for (int i = 0; i < n; i++) {
            int count = n - 1;
            StringBuilder sb = new StringBuilder();
            while (count >= 0) {
                int compare = 1 << count--;
                if ((compare & result[i]) != 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            returnArr[i] = sb.toString();
        }
        return returnArr;
    }
}
