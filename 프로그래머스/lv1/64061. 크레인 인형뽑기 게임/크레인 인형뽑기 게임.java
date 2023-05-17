import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int count = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0 ; i < moves.length ; i++) {
            for (int j = 0 ; j < board.length ; j++) {
                int value = board[j][moves[i] - 1];
                if (value != 0) {
                    if (!stack.isEmpty() && stack.peek() == value) {
                        stack.pop();
                        count += 2;
                    } else {
                        stack.push(value);
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        return count;
    }
}