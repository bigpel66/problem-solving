import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>() {{
        put("RT", 0);
        put("CF", 0);
        put("JM", 0);
        put("AN", 0);
    }};
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        for (int i = 0 ; i < survey.length ; i++) {
            char[] e = survey[i].toCharArray();
            Arrays.sort(e);
            String s = new String(e);
            int append = (s.equals(survey[i]) ? 1 : -1) * (choices[i] - 4);
            map.put(s, map.get(s) + append);
        }
        answer += map.get("RT") > 0 ? "T" : "R";
        answer += map.get("CF") > 0 ? "F" : "C";
        answer += map.get("JM") > 0 ? "M" : "J";
        answer += map.get("AN") > 0 ? "N" : "A";
        return answer;
    }
}