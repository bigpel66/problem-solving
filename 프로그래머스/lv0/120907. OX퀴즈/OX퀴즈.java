import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0 ; i < quiz.length ; i++) {
            String[] numbers = quiz[i].split(" [\\+\\-\\=] ");    
            String operator = Arrays.stream(quiz[i].split("\\-?\\d+|\\=")).filter(e -> !e.isBlank()).toArray()[0].toString().trim();
            int v1 = Integer.parseInt(numbers[0]);
            int v2 = Integer.parseInt(numbers[1]);
            int res = Integer.parseInt(numbers[2]);
            if (operator.equals("+")) {
                answer[i] = v1 + v2 == res ? "O" : "X";
            } else {
                answer[i] = v1 - v2 == res ? "O" : "X";
            }
        }
        return answer;
    }
}