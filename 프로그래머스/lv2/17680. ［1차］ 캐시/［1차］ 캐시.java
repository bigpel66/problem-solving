import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
         if (cacheSize == 0) {
            return cities.length * 5;
        }
        int answer = 0;
        List<String> order = new ArrayList<>();
        Set<String> cache = new HashSet<>();
        for (int i = 0; i < cities.length; i++) {
            String entry = cities[i].toUpperCase();
            if (cache.contains(entry)) {
                answer++;
                int index = order.indexOf(entry);
                order.remove(index);
            } else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    String oldest = order.get(0);
                    order.remove(0);
                    cache.remove(oldest);
                }
                cache.add(entry);
            }
            order.add(entry);
        }
        return answer;
    }
}