import java.util.*;

class Solution {    
    static Map<String, String> map = new HashMap<>() {{
        put("zero", "0");
        put("one", "1");
        put("two", "2");
        put("three", "3");
        put("four", "4");
        put("five", "5");
        put("six", "6");
        put("seven", "7");
        put("eight", "8");
        put("nine", "9");
    }};
    
    public long solution(String numbers) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
           numbers = numbers.replaceAll(entry.getKey(), entry.getValue()); 
        }
        return Long.parseLong(numbers);
    }
}