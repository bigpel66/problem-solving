import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class Main {
    private final StringBuilder sb;
    private int numberOfSequence;
    private double[] dp, value;

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
        numberOfSequence = Integer.parseInt(br.readLine());
        dp = new double[numberOfSequence + 1];
        value = new double[numberOfSequence + 1];
        for (int i = 1; i <= numberOfSequence; i++) {
            value[i] = Double.parseDouble(br.readLine());
        }
    }

    private void solve() {
        for (int i = 1; i <= numberOfSequence; i++) {
            dp[i] = Math.max(value[i], value[i] * dp[i - 1]);
        }
        double answer = Arrays.stream(dp).max().getAsDouble();
        sb.append(String.format("%.3f", answer));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
