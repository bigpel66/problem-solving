import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class Main {
    private static final int MOD = 10_007;
    private final StringBuilder sb;

    private int floor;
    private int[] value;

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
        floor = Integer.parseInt(br.readLine());
        value = new int[10];
        for (int i = 0; i < 10; i++) {
            value[i] = 10 - i;
        }
    }

    private void solve() {
        if (floor == 1) {
            sb.append(10);
        } else {
            for (int i = 3; i <= floor; i++) {
                for (int j = 9; j >= 1; j--) {
                    value[j - 1] += value[j];
                    value[j - 1] %= MOD;
                }
            }
            sb.append(Arrays.stream(value).sum() % MOD);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
