class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int curX = 0;
        int curY = 0;
        for (int i = 0 ; i < keyinput.length ; i++) {
            if (isRowMove(keyinput[i])) {
                curX = moveInRange(keyinput[i].equals("left") ? -1 : 1, curX, (board[0] - 1) / 2);
            } else {
                curY = moveInRange(keyinput[i].equals("down") ? -1 : 1, curY, (board[1] - 1) / 2);
            }
        }
        return new int[] {curX, curY};
    }
    
    public boolean isRowMove(String move) {
        return move.equals("left") || move.equals("right");
    }
    
    public int moveInRange(int displacement, int current, int limit) {
        if (current + displacement < limit * -1 || current + displacement > limit) {
            return current;
        }
        return current + displacement;
    }

}