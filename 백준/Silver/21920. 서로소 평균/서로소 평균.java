import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int numberOfSequence, valueX;
    private int[] sequence;
    private List<Integer> disjoint = new ArrayList<>();

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuffer();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        numberOfSequence = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sequence = new int[numberOfSequence];
        for (int i = 0; i < numberOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        valueX = Integer.parseInt(br.readLine());
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private void solve() {
        for (int i = 0; i < numberOfSequence; i++) {
            if (gcd(sequence[i], valueX) == 1) {
                disjoint.add(sequence[i]);
            }
        }
        double sum = disjoint.stream().mapToDouble(e -> e).sum() / disjoint.size();
        sb.append(BigDecimal.valueOf(sum).setScale(6, RoundingMode.HALF_UP));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}