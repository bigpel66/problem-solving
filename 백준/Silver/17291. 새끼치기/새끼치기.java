import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int targetYear;
    private int[] period;

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
        targetYear = Integer.parseInt(br.readLine());
        period = new int[targetYear + 1];
        period[0] = period[1] = 1;
    }

    private void solve() {
        for (int i = 1; i <= targetYear - 1; i++) {
            period[i + 1] = period[i] * 2;
            if (i % 2 == 0) {
                continue;
            }
            if (i + 1 - 3 >= 1) {
                period[i + 1] -= period[i - 3];
            }
            if (i + 1 - 4 >= 1) {
                period[i + 1] -= period[i - 4];
            }
        }
        sb.append(period[targetYear]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
