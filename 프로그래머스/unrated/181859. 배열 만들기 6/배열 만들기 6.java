import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < arr.length ; ) {
            if (list.isEmpty()) {
                list.add(arr[i++]);
            } else if (list.get(list.size() - 1) == arr[i]) {
                list.remove(list.size() - 1);
                i++;
            } else {
                list.add(arr[i++]);
            }
        }
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
    }
}