import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private static final int MOD = 10007;
    private final StringBuilder sb;

    private int row, col;
    private int[][] dp, map;


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
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        dp = new int[row + 1][col + 1];
        map = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private int max(int firstArg, int... rest) {
        int max = firstArg;
        for (int r : rest) {
            max = Math.max(max, r);
        }
        return max;
    }

    private void solve() {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = map[i][j] + max(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
            }
        }
        sb.append(dp[row][col]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
