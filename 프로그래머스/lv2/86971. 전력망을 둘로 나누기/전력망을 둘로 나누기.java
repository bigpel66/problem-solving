import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        boolean[][] adjacentMatrix = new boolean[n + 1][n + 1];
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            adjacentMatrix[wires[i][0]][wires[i][1]] = adjacentMatrix[wires[i][1]][wires[i][0]] = true;
        }
        for (int i = 0; i < wires.length; i++) {
            adjacentMatrix[wires[i][0]][wires[i][1]] = adjacentMatrix[wires[i][1]][wires[i][0]] = false;
            diff = Math.min(diff, bfs(wires[i][0], n, adjacentMatrix));
            adjacentMatrix[wires[i][0]][wires[i][1]] = adjacentMatrix[wires[i][1]][wires[i][0]] = true;
        }
        return diff;
    }

    public int bfs(int start, int n, boolean[][] adjacentMatrix) {
        int count = 1;
        boolean[] isVisited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            isVisited[value] = true;
            for (int i = 1; i <= n; i++) {
                if (!isVisited[i] && adjacentMatrix[value][i]) {
                    queue.offer(i);
                    count++;
                }
            }
        }
        return Math.abs(count - (n - count));
    }
}