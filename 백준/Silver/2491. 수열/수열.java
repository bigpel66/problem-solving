import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfSequence;
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
        numberOfSequence = Integer.parseInt(br.readLine());
        dp = new int[numberOfSequence + 1][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfSequence; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());
        }
        dp[1][1] = dp[1][2] = 1;
    }

    private void solve() {
        int answer = 1;
        for (int i = 2; i <= numberOfSequence; i++) {
            if (dp[i - 1][0] <= dp[i][0]) {
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][1] = 1;
            }
            if (dp[i - 1][0] >= dp[i][0]) {
                dp[i][2] = dp[i - 1][2] + 1;
            } else {
                dp[i][2] = 1;
            }
            answer = Math.max(answer, Math.max(dp[i][1], dp[i][2]));
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
