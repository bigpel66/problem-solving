import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        // StringBuilder sb = new StringBuilder();
        // boolean isCapital = true;
        // for (int i = 0 ; i < s.length() ; i++) {
        //     if (s.charAt(i) != ' ') {
        //         sb.append(isCapital ? Character.toUpperCase(s.charAt(i)) : Character.toLowerCase(s.charAt(i)));
        //         isCapital = !isCapital;
        //     } else {
        //         isCapital = true;
        //         sb.append(' ');
        //     }
        // }
        // return sb.toString();
        
        String[] split = s.split("");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String ch : split) {
            count = ch.contains(" ") ? 0 : count + 1;
            sb.append(count % 2 == 0 ? ch.toLowerCase() : ch.toUpperCase());
        }
        return sb.toString();
    }
}