import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String myStr) {
        String[] split = myStr.split("[abc]+");
        String[] answer = Arrays.stream(split).filter(i -> !i.isBlank()).toArray(String[]::new);
        return answer.length == 0 ? new String[]{"EMPTY"} : answer;
    }
}