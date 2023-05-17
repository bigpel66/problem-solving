import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Solution {
    public class Tuple {
        public String s;
        
        public TreeSet<List<Integer>> set;
        
        public Tuple(String s) {
            this.s = s.substring(2, s.length() - 2);
            set = new TreeSet<>(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> v1, List<Integer>v2) {
                    return Integer.compare(v1.size(), v2.size());
                }
            });
            init();
        }
        
        public void init() {
            String[] split = s.split("\\}\\,\\{");
            Arrays.stream(split).forEach(i -> {
                String[] e = i.split("\\,");
                set.add(Arrays.stream(e).map(j -> Integer.parseInt(j)).collect(Collectors.toList()));
            });
        }
        
        public List<Integer> original() {
            Map<Integer, Integer> map = new HashMap<>();
            for (List<Integer> l : set) {
                for (int i : l) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
            List<Map.Entry<Integer, Integer>> entry = new ArrayList<>(map.entrySet());
            entry.sort((v1, v2) -> Integer.compare(v2.getValue(), v1.getValue()));
            return entry.stream().map(e -> e.getKey()).collect(Collectors.toList());
        }
    }
                                
    public int[] solution(String s) {
        Tuple t = new Tuple(s);
        return t.original().stream().mapToInt(Integer::intValue).toArray();
    }
}