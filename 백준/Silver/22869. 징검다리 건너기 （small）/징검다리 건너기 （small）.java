import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfBridge, powerLimit;
    private int[] bridge;
    private boolean[] dp;

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
        numberOfBridge = Integer.parseInt(st.nextToken());
        powerLimit = Integer.parseInt(st.nextToken());
        bridge = new int[numberOfBridge + 1];
        dp = new boolean[numberOfBridge + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfBridge; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
    }

    private int getPower(int curr, int next) {
        return (next - curr) * (Math.abs(bridge[curr] - bridge[next]) + 1);
    }

    private void getWay(int curr) {
        if (dp[curr]) {
            return;
        }
        dp[curr] = true;
        if (curr == numberOfBridge) {
            return;
        }
        for (int next = curr + 1; next <= numberOfBridge; next++) {
            if (getPower(curr, next) <= powerLimit) {
                getWay(next);
            }
        }
    }

    private void solve() {
        getWay(1);
        sb.append(dp[numberOfBridge] ? "YES" : "NO");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
