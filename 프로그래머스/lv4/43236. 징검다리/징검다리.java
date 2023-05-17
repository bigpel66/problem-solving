import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        List<Integer> list = generateDistanceDiffs(distance, rocks);
        int start = 1;
        int end = 1000000000;
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int diff = 0;
            int removedCount = 0;
            for (int i : list) {
                diff += i;
                if (diff < mid) {
                    removedCount++;
                } else {
                    diff = 0;
                }
            }
            if (removedCount > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public List<Integer> generateDistanceDiffs(int distance, int[] rocks) {
        Arrays.sort(rocks);
        List<Integer> list = new ArrayList<>() {{
            add(rocks[0]);
        }};
        for (int i = 1; i < rocks.length; i++) {
            list.add(rocks[i] - rocks[i - 1]);
        }
        list.add(distance - rocks[rocks.length - 1]);
        return list;
    }
}