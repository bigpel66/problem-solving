import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                list.push('(');
            } else if (s.charAt(i) == ')' && !list.isEmpty()) {
                list.pop();
            } else {
                return false;
            }
        }
        return list.empty();
    }
}