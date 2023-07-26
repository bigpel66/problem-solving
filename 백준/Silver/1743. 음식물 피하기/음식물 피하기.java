import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int row, col, numberOfGarbage, answer, temp;
    boolean[][] map;
    boolean[][] isVisited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        numberOfGarbage = Integer.parseInt(st.nextToken());
        map = new boolean[row][col];
        isVisited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                isVisited[i][j] = true;
            }
        }
        for (int i = 0; i < numberOfGarbage; i++) {
            StringTokenizer pos = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(pos.nextToken());
            int y = Integer.parseInt(pos.nextToken());
            map[x - 1][y - 1] = true;
            isVisited[x - 1][y - 1] = false;
        }
    }

    void dfs(int x, int y) {
        isVisited[x][y] = true;
        answer = Math.max(answer, ++temp);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                continue;
            }
            if (isVisited[nx][ny] || !map[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }

    void solve() throws Exception {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isVisited[i][j] || !map[i][j]) {
                    continue;
                }
                temp = 0;
                dfs(i, j);
            }
        }
        bw.write(Integer.valueOf(answer).toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}