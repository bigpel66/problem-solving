import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int mazeSize;
    private int[] maze;
    private long[] dp;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        mazeSize = Integer.parseInt(br.readLine());
        dp = new long[mazeSize + 1];
        maze = new int[mazeSize + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= mazeSize; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
    }

    private void solve() {
        for (int i = 1; i <= mazeSize; i++) {
            int available = maze[i];
            for (int j = 1; j <= available && i + j <= mazeSize; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        sb.append(dp[mazeSize] >= Integer.MAX_VALUE ? -1 : dp[mazeSize]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
