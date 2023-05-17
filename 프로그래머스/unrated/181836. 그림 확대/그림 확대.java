import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < picture.length ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0 ; j < picture[i].length() ; j++) {
                Character ch = picture[i].charAt(j);
                sb.append(ch.toString().repeat(k));
            }
            for (int j = 0 ; j < k ; j++) {
                list.add(sb.toString());   
            }
        }
        return list.stream().toArray(String[]::new);
    }
}