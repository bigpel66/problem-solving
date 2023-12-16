import java.io.*;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfDesk, answer, max;
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
        numberOfDesk = Integer.parseInt(br.readLine());
        dp = new int[numberOfDesk + 1][6];
        for (int i = 1; i <= numberOfDesk; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstGrade = Integer.parseInt(st.nextToken());
            int secondGrade = Integer.parseInt(st.nextToken());
            dp[i][firstGrade]++;
            dp[i][secondGrade]++;
        }
        answer = -1;
        max = Integer.MIN_VALUE;
    }

    private int iterateDesks(int selectedGrade) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 1; i <= numberOfDesk; i++) {
            if (dp[i][selectedGrade] == 0) {
                max = Math.max(max, cur);
                cur = 0;
            } else {
                cur++;
            }
        }
        return Math.max(0, Math.max(max, cur));
    }

    private void solve() {
        for (int i = 1; i <= 5; i++) {
            int localMax = iterateDesks(i);
            if (max < localMax) {
                max = localMax;
                answer = i;
            }
        }
        sb.append(max).append(" ").append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
