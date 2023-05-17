import java.util.*;

class Solution {
    public int solution(String my_string) {
        String[] split = my_string.split(" ");
        int acc = Integer.parseInt(split[0]);
        Stack<String> stack = new Stack<>();
        for (int i = 1 ; i < split.length ; i++) {
            if (split[i].equals("+") || split[i].equals("-")) {
                stack.push(split[i]);
            } else {
                int value = Integer.parseInt(split[i]);
                String operator = stack.pop();
                if (operator.equals("+")) {
                    acc += value;
                } else {
                    acc -= value;
                }
            }
        }
        return acc;
    }
}