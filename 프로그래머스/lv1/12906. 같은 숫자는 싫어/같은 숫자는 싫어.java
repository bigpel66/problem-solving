import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) != arr[i]) {
                list.add(arr[i]);
            }
        }
        return list.stream().mapToInt(e -> e).toArray();
    }
}