import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private static final int EMPTY = 0;
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final int MOD = 9_901;
    private final StringBuilder sb;

    private int height;
    private int[][] cage;

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
        height = Integer.parseInt(br.readLine());
        cage = new int[height + 1][3];
        cage[1][EMPTY] = cage[1][FIRST] = cage[1][SECOND] = 1;
    }

    private void solve() {
        for (int i = 2; i <= height; i++) {
            cage[i][EMPTY] = (cage[i - 1][EMPTY] + cage[i - 1][FIRST] + cage[i - 1][SECOND]) % MOD;
            cage[i][FIRST] = (cage[i - 1][EMPTY] + cage[i - 1][SECOND]) % MOD;
            cage[i][SECOND] = (cage[i - 1][EMPTY] + cage[i - 1][FIRST]) % MOD;
        }
        sb.append((cage[height][EMPTY] + cage[height][FIRST] + cage[height][SECOND]) % MOD);

    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
