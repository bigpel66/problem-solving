import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < my_string.length() ; i++) {
            list.add(my_string.substring(my_string.length() - 1 - i));
        }
        list.sort(Comparator.naturalOrder());
        return list.stream().toArray(String[]::new);
    }
}