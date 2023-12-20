import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private static final int MOD = 1_000_000_009;
    private final StringBuilder sb;
    private int targetNumber;
    private long[] dp;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            int numberOfTest = Integer.parseInt(br.readLine());
            initDp();
            while (numberOfTest-- > 0) {
                getInput(br);
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void initDp() {
        dp = new long[1_000_000 + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        targetNumber = Integer.parseInt(br.readLine());
    }

    private void solve() {
        sb.append(dp[targetNumber]).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
