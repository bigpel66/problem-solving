import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int rowSize, colSize;
    char[][] map;
    int[][] dist;
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.naturalOrder());

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());
        map = new char[rowSize][colSize];
        dist = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            String line = br.readLine();
            for (int j = 0; j < colSize; j++) {
                map[i][j] = (char) (line.charAt(j) - '0');
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    void solve() {
        pq.offer(new Point(0, 0, 0));
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            int cost = cur.negativeCount * -1;
            if (cur.x == rowSize - 1 && cur.y == colSize - 1) {
                sb.append(cost);
                return;
            }
            if (dist[cur.x][cur.y] < cost) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if (nextX < 0 || nextX >= rowSize || nextY < 0 || nextY >= colSize) {
                    continue;
                }
                int nextCost = cost + map[nextX][nextY];
                if (dist[nextX][nextY] > nextCost) {
                    dist[nextX][nextY] = nextCost;
                    pq.offer(new Point(nextX, nextY, nextCost * -1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public class Point implements Comparable<Point> {
        public int x;
        public int y;
        public int negativeCount;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.negativeCount = cost;
        }

        @Override
        public int compareTo(Point point) {
            return Integer.compare(point.negativeCount, negativeCount);
        }
    }

}