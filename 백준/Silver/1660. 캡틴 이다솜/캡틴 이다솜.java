import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class Main {
    private final StringBuilder sb;

    private int limit;
    
    private int[] shape, dp;

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
        limit = Integer.parseInt(br.readLine());
        shape = new int[1 << 7 + 1];
        dp = new int[limit + 1];
        for (int i = 1; i <= 1 << 7 ; i++) {
            shape[i] = i;
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
    }
  
    private void acc() {
        for (int i = 1; i <= 1 << 7; i++) {
            shape[i] += shape[i - 1];
        }
    }
    
    private void tetrahedron() {
        acc();
        acc();
    }
    
    private void solve() {
        tetrahedron();
        for (int i = 2; i <= limit; i++) {
            for (int j = 1; j <= 1 << 7 ; j++) {
                if (shape[j] > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - shape[j]] + 1);
            }
        }
        sb.append(dp[limit]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
