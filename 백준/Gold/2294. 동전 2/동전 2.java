import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class Main {
    private static final int MAX = 1_000_000;
    private final StringBuilder sb;
    private int numberOfCoin, goalAsset;
    private int[] values, dp;

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
        numberOfCoin = Integer.parseInt(st.nextToken());
        goalAsset = Integer.parseInt(st.nextToken());
        values = new int[numberOfCoin + 1];
        dp = new int[goalAsset + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i <= numberOfCoin; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
    }

    private void updateKnapsack(int value) {
        for (int i = value; i <= goalAsset; i++) {
            if (dp[i - value] == MAX) {
                continue;
            }
            dp[i] = Math.min(dp[i], dp[i - value] + 1);
        }
    }

    private void solve() {
        for (int i = 1; i <= numberOfCoin; i++) {
            updateKnapsack(values[i]);
        }
        sb.append(dp[goalAsset] == MAX ? -1 : dp[goalAsset]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
