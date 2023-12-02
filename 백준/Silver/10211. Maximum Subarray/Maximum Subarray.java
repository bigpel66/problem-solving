import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int valueSize, answer;
    private int[] dp, value;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            int numberOfTest = Integer.parseInt(br.readLine());
            while (numberOfTest-- > 0) {
                getInput(br);
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        valueSize = Integer.parseInt(br.readLine());
        value = new int[valueSize + 1];
        dp = new int[valueSize + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= valueSize; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        answer = Integer.MIN_VALUE;
    }

    private void solve() {
        for (int i = 1; i <= valueSize; i++) {
            dp[i] = Math.max(value[i], dp[i - 1] + value[i]);
            answer = Math.max(answer, dp[i]);
        }
        sb.append(answer).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
