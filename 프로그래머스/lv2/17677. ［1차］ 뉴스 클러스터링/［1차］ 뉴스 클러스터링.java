import java.util.*;

class Solution {
     public int solution(String str1, String str2) {
        Map<String, Integer> stringMap1 = generateChunkedStringMap(str1);
        Map<String, Integer> stringMap2 = generateChunkedStringMap(str2);
        Set<String> stringSet1 = stringMap1.keySet();
        Set<String> stringSet2 = stringMap2.keySet();
        Set<String> intersectionSet = new HashSet<>(stringSet1);
        intersectionSet.retainAll(stringSet2);
        Set<String> unionSet = new HashSet<>(stringSet1);
        unionSet.addAll(stringSet2);
        int intersectionCount = intersectionSet.stream().mapToInt(e -> Math.min(stringMap1.get(e), stringMap2.get(e))).sum();
        int unionCount = unionSet.stream().mapToInt(e -> Math.max(stringMap1.getOrDefault(e, 0), stringMap2.getOrDefault(e, 0))).sum();
        if (unionCount == 0) {
            return 65536;
        } else {
            return 65536 * intersectionCount / unionCount;
        }
    }

    public Map<String, Integer> generateChunkedStringMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i + 2).toLowerCase();
            if (isNonAlphabeticIncluded(s)) {
                continue;
            }
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }

    public boolean isNonAlphabeticIncluded(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}