import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int nSize;
    private int[][] forward;
    private long[][] dp;

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
        nSize = Integer.parseInt(br.readLine());
        forward = new int[nSize][nSize];
        dp = new long[nSize][nSize];
        for (int i = 0; i < nSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < nSize; j++) {
                forward[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
    }

    private void calcPossibilities() {
        for (int i = 0; i < nSize; i++) {
            for (int j = 0; j < nSize; j++) {
                int value = forward[i][j];
                if (value == 0) {
                    return;
                }
                if (i + value < nSize) {
                    dp[i + value][j] += dp[i][j];
                }
                if (j + value < nSize) {
                    dp[i][j + value] += dp[i][j];
                }
            }
        }
    }

    private void solve() {
        calcPossibilities();
        sb.append(dp[nSize - 1][nSize - 1]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
