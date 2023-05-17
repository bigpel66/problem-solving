import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        return len1 == len2 
            ? Integer.compare(Arrays.stream(arr1).sum(), Arrays.stream(arr2).sum()) 
            : Integer.compare(len1, len2);
    }
}