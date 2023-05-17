import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        List<Integer> list = Arrays.asList(a, b, c, d);
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.size() == 4) {
            return list.stream().mapToInt(i -> i).min().getAsInt();
        }
        else if (map.size() == 1) {
            return a * 1111;
        } else if (map.size() == 2) {
            List<Integer> keys = new ArrayList<>(map.keySet());
            Set<Integer> values = new HashSet<>(map.values());
            if (values.contains(2)) {
                return (keys.get(0) + keys.get(1)) * Math.abs(keys.get(0) - keys.get(1));
            } else {
                int p = map.get(keys.get(0)) == 1 ? keys.get(1) : keys.get(0);
                int q = map.get(keys.get(0)) == 1 ? keys.get(0) : keys.get(1);
                return (int) Math.pow(10 * p + q, 2);
            }    
        } else {
            List<Integer> sub = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 2) {
                    sub.add(entry.getKey());
                }
            }
            return sub.get(0) * sub.get(1);
        }
    }
}