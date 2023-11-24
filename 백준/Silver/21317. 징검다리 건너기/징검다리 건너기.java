import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private static final int MAX = 100_000;
    private static final int SUPER_JUMP_UNUSED = 0;
    private static final int SUPER_JUMP_USED = 1;
    private static final int ONE_STEP = 0;
    private static final int TWO_STEP = 1;
    private static final int MAX_STEP_SIZE = 3;
    private final StringBuilder sb;
    private int numberOfBridge, superJumpCost;
    private int[][] bridge;
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
        numberOfBridge = Integer.parseInt(br.readLine());
        bridge = new int[numberOfBridge + 1 + MAX_STEP_SIZE][2];
        dp = new int[numberOfBridge + 1 + MAX_STEP_SIZE][2];
        for (int i = 1; i < numberOfBridge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int oneStep = Integer.parseInt(st.nextToken());
            int twoStep = Integer.parseInt(st.nextToken());
            bridge[i][ONE_STEP] = oneStep;
            bridge[i][TWO_STEP] = twoStep;
        }
        for (int[] inner : dp) {
            inner[0] = MAX;
            inner[1] = MAX;
        }
        dp[0][SUPER_JUMP_UNUSED] = dp[0][SUPER_JUMP_USED] = dp[1][SUPER_JUMP_UNUSED] = dp[1][SUPER_JUMP_USED] = 0;
        superJumpCost = Integer.parseInt(br.readLine());
    }

    private void solve() {
        for (int i = 1; i <= numberOfBridge; i++) {
            dp[i + 1][SUPER_JUMP_UNUSED] = Math.min(dp[i][SUPER_JUMP_UNUSED] + bridge[i][ONE_STEP], dp[i + 1][SUPER_JUMP_UNUSED]);
            dp[i + 2][SUPER_JUMP_UNUSED] = Math.min(dp[i][SUPER_JUMP_UNUSED] + bridge[i][TWO_STEP], dp[i + 2][SUPER_JUMP_UNUSED]);
            dp[i + 3][SUPER_JUMP_USED] = Math.min(dp[i + 1][SUPER_JUMP_USED] + bridge[i + 1][TWO_STEP], dp[i + 3][SUPER_JUMP_USED]);
            dp[i + 3][SUPER_JUMP_USED] = Math.min(dp[i + 2][SUPER_JUMP_USED] + bridge[i + 2][ONE_STEP], dp[i + 3][SUPER_JUMP_USED]);
            dp[i + 3][SUPER_JUMP_USED] = Math.min(dp[i][SUPER_JUMP_UNUSED] + superJumpCost, dp[i + 3][SUPER_JUMP_USED]);
        }
        sb.append(Math.min(dp[numberOfBridge][SUPER_JUMP_UNUSED], dp[numberOfBridge][SUPER_JUMP_USED]));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
