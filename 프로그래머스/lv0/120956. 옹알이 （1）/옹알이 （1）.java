import java.util.*;
import java.util.stream.*;

class Solution {
    
    static public String[] words = { "aya", "ye", "woo", "ma" };
    
    public int solution(String[] babbling) {
        int answer = Arrays.stream(babbling).mapToInt(e -> {
            for (int i = 0 ; i < words.length; i++) {
                e = e.replaceFirst(words[i], " ");
            }
            if (e.isBlank()) {
                return 1;
            }
            return 0;
        }).sum();
        return answer;
    }
}