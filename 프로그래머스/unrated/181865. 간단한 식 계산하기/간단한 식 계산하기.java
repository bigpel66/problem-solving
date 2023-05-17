import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String binomial) {
        String[] operands = binomial.split(" [\\+\\-\\*] ");
        String[] operators = binomial.split("[\\d\\s]+");
        int a = Integer.parseInt(operands[0]);
        int b = Integer.parseInt(operands[1]);
        switch (operators[1].charAt(0)) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }
}