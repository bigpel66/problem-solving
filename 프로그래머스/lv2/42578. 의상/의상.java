import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        Collection<Integer> values = map.values();
        return values.stream().reduce(1, (x, y) -> x * y).intValue() - 1;
    }
}