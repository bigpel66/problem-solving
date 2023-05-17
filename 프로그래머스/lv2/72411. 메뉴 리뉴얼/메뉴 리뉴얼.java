import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<Map<String, Integer>> subset = generateSubsetList();
        for (int i = 0 ; i < orders.length ; i++) {
            generateSubsetString(orders[i], subset);
        }
        return filterSubsetWithCourse(subset, course);
    }
    
    public List<Map<String, Integer>> generateSubsetList() {
        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 0 ; i < 11 ; i++) {
            list.add(new HashMap<>());
        }
        return list;
    }
    
    public void generateSubsetString(String order, List<Map<String, Integer>> subset) {
        for (int i = 1 ; i < (1 << order.length()) ; i++) {
            char[] arr = extractSubsetCharArray(i, order);
            if (arr.length == 1) {
                continue;
            }
            Arrays.sort(arr);
            recordStringOnSubset(subset, new String(arr));
        }
    }
    
    public char[] extractSubsetCharArray(int bitset, String original) {
        StringBuilder sb = new StringBuilder();
        for (int i = original.length() - 1 ; i >= 0 ; i--) {
            if ((bitset & 1) != 0) {
                sb.append(original.charAt(i));
            }
            bitset >>= 1;
        }
        return sb.toString().toCharArray();
    }
    
    public void recordStringOnSubset(List<Map<String, Integer>> subset, String s) {
        Map<String, Integer> map = subset.get(s.length());
        map.put(s, map.getOrDefault(s, 0) + 1);
        subset.set(s.length(), map);
    }
    
    public String[] filterSubsetWithCourse(List<Map<String, Integer>> subset, int[] course) {
        List<String> filtered = new ArrayList<>();
        for (int i = 0 ; i < course.length ; i++) {
            Map<String, Integer> courseMap = subset.get(course[i]);
            int max = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> entry: courseMap.entrySet()) {
                max = Math.max(max, entry.getValue());
            }
            for (Map.Entry<String, Integer> entry: courseMap.entrySet()) {
                if (entry.getValue() != 1 && entry.getValue() == max) {
                    filtered.add(entry.getKey());
                }
            }
        }
        return filtered.stream().sorted().toArray(String[]::new);
    }
}