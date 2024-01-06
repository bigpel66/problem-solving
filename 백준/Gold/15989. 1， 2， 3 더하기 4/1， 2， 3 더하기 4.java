import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int target;
    private int[][] dp;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            initDp();
            int numberOfTest = Integer.parseInt(br.readLine());
            while (numberOfTest-- > 0) {
                getInput(br);
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void initDp() {
        dp = new int[10001][4];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        target = Integer.parseInt(br.readLine());
    }

    private void solve() {
        sb.append(dp[target][1] + dp[target][2] + dp[target][3]).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}