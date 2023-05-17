import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int n) {
        if (arr.length % 2 == 0) {
            IntStream.range(0, arr.length).filter(i -> i % 2 == 1).forEachOrdered(i -> arr[i] += n);
        } else {
            IntStream.range(0, arr.length).filter(i -> i % 2 == 0).forEachOrdered(i -> arr[i] += n);
        }
        return arr;
    }
}