import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int targetNumber;
    private final int[] dp = new int[10_001];

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
        dp[1] = dp[3] = 1;
        dp[2] = 2;
    }

    private void solve() {
        for (int i = 4; i <= 10_000; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }
        sb.append(dp[targetNumber] % 2 == 1 ? "SK" : "CY");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
