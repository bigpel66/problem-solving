import java.util.*;

class Solution {
    static public class Point {

        public int iter;

        public int x;

        public int y;

        public Point(int x, int y, int iter) {
            this.x = x;
            this.y = y;
            this.iter = iter;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            Point other = (Point) o;
            return x == other.x && y == other.y && iter == other.iter;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, iter);
        }

    }

    public int solution(int m, int n, String[] board) {
        int iteration = 0;
        Set<Point> fixRequired = new HashSet<>();
        Set<Point> points = new HashSet<>();
        while (collapsed(m, n, board, iteration++, points, fixRequired)) {
            fixBoard(board, fixRequired);
            fixRequired.clear();
        }
        return points.size();
    }

    public boolean collapsed(int rowSize, int colSize, String[] board, int iteration, Set<Point> points, Set<Point> fixRequired) {
        boolean isCollapsed = false;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (isDetectable(i, j, rowSize, colSize) && isDetected(i, j, board)) {
                    collectPoints(i, j, iteration, points, fixRequired);
                    isCollapsed = true;
                }
            }
        }
        return isCollapsed;
    }

    public boolean isDetectable(int curX, int curY, int rowSize, int colSize) {
        return curX + 1 < rowSize && curY + 1 < colSize;
    }

    public boolean isDetected(int curX, int curY, String[] board) {
        char p1 = board[curX].charAt(curY);
        char p2 = board[curX + 1].charAt(curY);
        char p3 = board[curX].charAt(curY + 1);
        char p4 = board[curX + 1].charAt(curY + 1);
        return p1 != '0' && (p1 == p2 && p2 == p3 && p3 == p4 && p4 == p1);
    }

    public void collectPoints(int i, int j, int iteration, Set<Point> points, Set<Point> fixRequired) {
        List<Point> samePoints = Arrays.asList(
                new Point(i, j, iteration),
                new Point(i, j + 1, iteration),
                new Point(i + 1, j, iteration),
                new Point(i + 1, j + 1, iteration)
        );
        points.addAll(samePoints);
        fixRequired.addAll(samePoints);
    }

    public void fixBoard(String[] board, Set<Point> fixRequired) {
        for (Point e : fixRequired) {
            String record = board[e.x];
            String fixed = record.substring(0, e.y) + '0' + record.substring(e.y + 1);
            board[e.x] = fixed;
        }
        while (true) {
            boolean isMoved = false;
            for (int i = 0; i < board.length - 1; i++) {
                for (int j = 0; j < board[0].length(); j++) {
                    if (board[i].charAt(j) == '0') {
                        continue;
                    }
                    if (board[i + 1].charAt(j) == '0') {
                        isMoved = true;
                        String nextRecord = board[i + 1];
                        String nextFixed = nextRecord.substring(0, j) + board[i].charAt(j) + nextRecord.substring(j + 1);
                        board[i + 1] = nextFixed;
                        String curRecord = board[i];
                        String curFixed = curRecord.substring(0, j) + '0' + curRecord.substring(j + 1);
                        board[i] = curFixed;
                    }
                }
            }
            if (!isMoved) {
                break;
            }
        }
    }
}