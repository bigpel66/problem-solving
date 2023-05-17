import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static private final int[][] displacement = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int solution(int[][] maps) {
        int[][] visitedCost = new int[maps.length][maps[0].length];
        bfs(maps, visitedCost);
        return visitedCost[maps.length - 1][maps[0].length - 1] == 0 ? -1 : visitedCost[maps.length - 1][maps[0].length - 1];
    }

    public void bfs(int[][] maps, int[][] visitedCost) {
        visitedCost[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>() {{
            add(new int[]{0, 0});
        }};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + displacement[i][0];
                int nextY = curY + displacement[i][1];
                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) {
                    continue;
                }
                if (visitedCost[nextX][nextY] == 0 && maps[nextX][nextY] == 1) {
                    visitedCost[nextX][nextY] = visitedCost[curX][curY] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }
}