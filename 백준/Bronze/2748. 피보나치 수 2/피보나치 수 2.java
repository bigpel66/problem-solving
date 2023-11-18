import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int index;
    private final long[] dp = new long[91];

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
        index = Integer.parseInt(br.readLine());
    }

    private void solve() {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= 90; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        sb.append(dp[index]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
