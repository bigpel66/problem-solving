import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] seoul) {
        return String.format("김서방은 %d에 있다", Arrays.stream(seoul).collect(Collectors.toList()).indexOf("Kim"));
        // int index = IntStream.range(0, seoul.length).filter(e -> seoul[e].equals("Kim")).toArray()[0];
        // return String.format("김서방은 %d에 있다", index);
    }
}