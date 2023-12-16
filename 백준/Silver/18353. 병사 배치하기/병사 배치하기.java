import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfSoldier;
    private int[] dp, power;

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
        numberOfSoldier = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[numberOfSoldier + 1];
        power = new int[numberOfSoldier + 1];
        for (int i = numberOfSoldier; i >= 1; i--) {
            power[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
    }

    private void solve() {
        for (int i = 1; i <= numberOfSoldier; i++) {
            for (int j = 1; j < i; j++) {
                if (power[i] <= power[j]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = dp[1];
        for (int i = 2; i <= numberOfSoldier; i++) {
            max = Math.max(max, dp[i]);
        }
        sb.append(numberOfSoldier - max);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
