import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int numberOfSnack;
    private int[] dp, snack;

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
        numberOfSnack = Integer.parseInt(br.readLine());
        dp = new int[numberOfSnack + 1];
        snack = new int[numberOfSnack + 1];
        for (int i = 1; i <= numberOfSnack; i++) {
            snack[i] = Integer.parseInt(br.readLine());
            dp[i] = snack[i];
        }
    }

    private void solve() {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= numberOfSnack; i++) {
            for (int j = i + 1; j <= numberOfSnack; j++) {
                if (snack[i] < snack[j] && dp[j] < dp[i] + snack[j]) {
                    dp[j] = dp[i] + snack[j];
                    max = Math.max(max, dp[j]);
                }
            }
        }
        sb.append(max);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
