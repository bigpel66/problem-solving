import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private static final int MOD = 10007;
    private final StringBuilder sb;
    private int n, k;
    private int[][] dp;

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
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];
    }

    private int recursive(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }
        if (n == k || k == 0) {
            return 1;
        }
        return dp[n][k] = (recursive(n - 1, k - 1) + recursive(n - 1, k)) % MOD;
    }

    private void solve() {
        sb.append(recursive(n, k));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
