import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // Map<String, Integer> map = new HashMap<>();
        // IntStream.range(0, name.length).forEachOrdered(n -> {
        //     map.put(name[n], yearning[n]);
        // });
        // List<Integer> list = new ArrayList<>();
        // IntStream.range(0, photo.length).forEachOrdered(i -> {
        //     list.add(IntStream.range(0, photo[i].length).map(j -> {
        //         return map.getOrDefault(photo[i][j], 0);
        //     }).sum());
        // });
        // return list.stream().mapToInt(Integer::intValue).toArray();
        
        Map<String, Integer> map = IntStream.range(0, name.length).mapToObj(i -> Map.entry(name[i], yearning[i])).collect(Collectors.toSet()).stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return Arrays.stream(photo).mapToInt(i -> Arrays.stream(i).mapToInt(j -> map.getOrDefault(j, 0)).sum()).toArray();
    }
}