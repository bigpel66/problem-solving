import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int targetCost;
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
        targetCost = Integer.parseInt(br.readLine());
        dp = new int[100_000 + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;
    }

    private int min(int first, int... rest) {
        int comp = first;
        for (int v : rest) {
            if (comp > v) {
                comp = v;
            }
        }
        return comp;
    }

    private void solve() {
        for (int i = 8; i <= targetCost; i++) {
            dp[i] = min(dp[i - 1], dp[i - 2], dp[i - 5], dp[i - 7]) + 1;
        }
        sb.append(dp[targetCost]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
