import java.util.*;
import java.util.stream.Collectors;

class Solution {

    static public final int[][] displacement = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    static public class Point {

        public int x;

        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Boolean equals(Point point) {
            return this.x == point.x && this.y == point.y;
        }

        static public Boolean equals(List<Point> p1, List<Point> p2) {
            if (p1.size() != p2.size()) {
                return false;
            }
            for (int i = 0; i < p1.size(); i++) {
                if (!p1.get(i).equals(p2.get(i))) {
                    return false;
                }
            }
            return true;
        }

    }

    public int solution(int[][] game_board, int[][] table) {
        List<List<Point>> piecesGameBoard = new ArrayList<>();
        List<List<Point>> piecesTable = new ArrayList<>();
        boolean[][] visitedGameBoard = new boolean[game_board.length][game_board.length];
        boolean[][] visitedTable = new boolean[game_board.length][game_board.length];
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if (game_board[i][j] == 0 && !visitedGameBoard[i][j]) {
                    piecesGameBoard.add(findPiece(i, j, visitedGameBoard, game_board, 0));
                }
                if (table[i][j] == 1 && !visitedTable[i][j]) {
                    piecesTable.add(findPiece(i, j, visitedTable, table, 1));
                }
            }
        }
        return getAreaOfMatchedPieces(piecesGameBoard, piecesTable);
    }

    List<Point> findPiece(int offsetX, int offsetY, boolean[][] visited, int[][] map, int shape) {
        Queue<Point> queue = new LinkedList<>() {{
            offer(new Point(offsetX, offsetY));
        }};
        List<Point> points = new ArrayList<>() {{
            add(new Point(offsetX - offsetX, offsetY - offsetY));
        }};
        visited[offsetX][offsetY] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int curX = point.x;
            int curY = point.y;
            for (int i = 0; i < displacement.length; i++) {
                int nextX = curX + displacement[i][0];
                int nextY = curY + displacement[i][1];
                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length) {
                    continue;
                }
                if (map[nextX][nextY] == shape && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY));
                    points.add(new Point(nextX - offsetX, nextY - offsetY));
                }
            }
        }
        return points;
    }

    int getAreaOfMatchedPieces(List<List<Point>> gameBoard, List<List<Point>> table) {
        int answer = 0;
        boolean[] isPieceOnTableConsumed = new boolean[table.size()];
        for (int i = 0; i < gameBoard.size(); i++) {
            List<Point> space = gameBoard.get(i);
            for (int j = 0; j < table.size(); j++) {
                List<Point> piece = table.get(j);
                if (isPieceOnTableConsumed[j] || space.size() != piece.size()) {
                    continue;
                }
                if (isPieceMatched(space, piece)) {
                    answer += space.size();
                    isPieceOnTableConsumed[j] = true;
                    break;
                }
            }
        }
        return answer;
    }

    boolean isPieceMatched(List<Point> p1, List<Point> p2) {
        p1.sort(comparePoint());
        for (int i = 0; i < 4; i++) {
            p2 = rotatePieces(p2);
            p2.sort(comparePoint());
            fixOrigin(p2);
            if (Point.equals(p1, p2)) {
                return true;
            }
        }
        return false;
    }

    List<Point> rotatePieces(List<Point> points) {
        return points.stream().map(e->rotateCCW(e)).collect(Collectors.toList());
    }

    Point rotateCCW(Point point) {
        return new Point(point.y, point.x * -1);
    }

    static public Comparator<Point> comparePoint() {
        return (v1, v2) -> v1.x > v2.x ? 1 : v1.x < v2.x ? -1 : Integer.compare(v1.y, v2.y);
    }

    public void fixOrigin(List<Point> points) {
        int minLeftX = points.get(0).x;
        int minLeftY = points.get(0).y;
        for (int i = 0; i < points.size(); i++) {
            points.set(i, new Point(points.get(i).x - minLeftX, points.get(i).y - minLeftY));
        }
    }

}
