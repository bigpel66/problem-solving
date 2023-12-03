import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private static final int MOD = 1_000_000_007;
    private final StringBuilder sb;
    private int target;
    private int[] dp;

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
        target = Integer.parseInt(br.readLine());
        dp = new int[target + 1];
        for (int i = 0; i < 2 && i <= target; i++) {
            dp[i] = i;
        }
    }

    private void solve() {
        for (int i = 2; i <= target; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        sb.append(dp[target]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
