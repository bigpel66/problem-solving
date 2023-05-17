class Solution {
    static public int answer = 0;
    
    static public final int[][] displacement = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = Integer.MAX_VALUE;
        Boolean[][] map = generateMap(rectangle);
        boolean[][] isVisited = new boolean[102][102];
        int adjustedCharX = characterX * 2, adjustedCharY = characterY * 2;
        int adjustedItemX = itemX * 2, adjustedItemY = itemY * 2;
        isVisited[adjustedCharX][adjustedCharY] = true;
        dfs(map, isVisited, adjustedCharX, adjustedCharY, adjustedItemX, adjustedItemY, 0);
        return answer / 2;
    }

    public void dfs(Boolean[][] map, boolean[][] isVisited, int curX, int curY, int targetX, int targetY, int count) {
        if (curX == targetX && curY == targetY) {
            answer = Math.min(answer, count);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = curX + displacement[i][0];
            int nextY = curY + displacement[i][1];
            if (nextX < 0 || nextX > 100 || nextY < 0 || nextY > 100) {
                continue;
            }
            if (map[nextX][nextY] == Boolean.TRUE && !isVisited[nextX][nextY]) {
                isVisited[nextX][nextY] = true;
                dfs(map, isVisited, nextX, nextY, targetX, targetY, count + 1);
                isVisited[nextX][nextY] = false;
            }
        }
    }

    Boolean[][] generateMap(int[][] rectangle) {
        Boolean[][] map = new Boolean[102][102];
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < 4; j++) {
                rectangle[i][j] *= 2;
            }
            for (int x = rectangle[i][0]; x <= rectangle[i][2]; x++) {
                for (int y = rectangle[i][1]; y <= rectangle[i][3]; y++) {
                    map[x][y] = (x == rectangle[i][0] || x == rectangle[i][2] || y == rectangle[i][1] || y == rectangle[i][3]) && map[x][y] != Boolean.FALSE;
                }
            }
        }
        return map;
    }
}