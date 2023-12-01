import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int targetNumber;
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
        targetNumber = Integer.parseInt(br.readLine());
        dp = new long[targetNumber + 1];
        dp[0] = 1;
    }

    private void solve() {
        for (int i = 1; i <= targetNumber; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        sb.append(dp[targetNumber]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
