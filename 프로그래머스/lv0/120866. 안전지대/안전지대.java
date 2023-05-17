import java.util.*;
import java.util.stream.*;

class Solution {
    public class Point {
        public int x;

        public int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            Point p = (Point) o;
            return p.x == this.x && p.y == this.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int solution(int[][] board) {
        Set<Point> points = new HashSet<>();
        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length ; j++) {
                if (board[i][j] == 1) {
                    points.add(new Point(i, j));
                    mark(points, board, j, i);
                }
            }
        }
        return board.length * board[0].length - points.size();
    }
    
    public void mark(Set<Point> points, int[][] board, int curX, int curY) {
        for (int i = curY - 1 ; i <= curY + 1 ; i++) {
            for (int j = curX - 1 ; j <= curX + 1 ; j++) {
                if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
                    continue;
                }
                points.add(new Point(i, j));
            }
        }    
    }
}
