import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private long target, aBundle, aPrice, bBundle, bPrice, answer;

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
        target = Long.parseLong(st.nextToken());
        aBundle = Long.parseLong(st.nextToken());
        aPrice = Long.parseLong(st.nextToken());
        bBundle = Long.parseLong(st.nextToken());
        bPrice = Long.parseLong(st.nextToken());
        answer = Long.MAX_VALUE;
    }

    private void setCostEffectiveAsB() {
        if (aPrice * bBundle < bPrice * aBundle) {
            long tempBundle = aBundle;
            aBundle = bBundle;
            bBundle = tempBundle;
            long tempPrice = aPrice;
            aPrice = bPrice;
            bPrice = tempPrice;
        }
    }

    private void bruteForceNonCostEffectiveUntilB() {
        for (long aCount = 0; aCount < bBundle; aCount++) {
            long bCount = (long) Math.ceil((double) (target - aCount * aBundle) / bBundle);
            boolean isFinished = false;
            if (bCount < 0) {
                bCount = 0;
                isFinished = true;
            }
            answer = Math.min(answer, aCount * aPrice + bCount * bPrice);
            if (isFinished) {
                break;
            }
        }
    }

    private void solve() {
        setCostEffectiveAsB();
        bruteForceNonCostEffectiveUntilB();
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}