import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;

    private int numberOfMeeting;
    private int[] meeting;
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
        numberOfMeeting = Integer.parseInt(br.readLine());
        meeting = new int[numberOfMeeting + 2];
        dp = new int[numberOfMeeting + 2][2];
        for (int i = 2; i < numberOfMeeting + 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            st.nextToken();
            meeting[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        for (int i = 2; i < numberOfMeeting + 2; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][1]) + meeting[i];
        }
        sb.append(Math.max(dp[numberOfMeeting + 1][0], dp[numberOfMeeting + 1][1]));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
