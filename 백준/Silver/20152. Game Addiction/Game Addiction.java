import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int diff;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int homeCoord = Integer.parseInt(st.nextToken());
        int cafeCoord = Integer.parseInt(st.nextToken());
        diff = Math.abs(homeCoord - cafeCoord);
        dp = new long[diff + 1][diff + 1];
        Arrays.fill(dp[0], 1);
    }

    private void solve() {
        for (int i = 1; i <= diff; i++) {
            dp[i][i] = dp[i - 1][i];
            for (int j = i + 1; j <= diff; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        sb.append(dp[diff][diff]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
