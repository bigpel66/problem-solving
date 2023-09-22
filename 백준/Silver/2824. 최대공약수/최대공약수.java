import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private final int MAX = 1_000_000_000;
    private int n, m;
    private long answer = 1L;
    private boolean isFolded;
    private Map<Integer, Integer> nFactor = new HashMap<>();
    private Map<Integer, Integer> mFactor = new HashMap<>();

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

    private void getFactor(int val, Map<Integer, Integer> factor) {
        for (int i = 2; i <= Math.sqrt(val); i++) {
            while (val % i == 0) {
                factor.put(i, factor.getOrDefault(i, 0) + 1);
                val /= i;
            }
        }
        if (val != 1) {
            factor.put(val, factor.getOrDefault(val, 0) + 1);
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            getFactor(val, nFactor);
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(st.nextToken());
            getFactor(val, mFactor);
        }
    }

    private void solve() {
        for (Map.Entry<Integer, Integer> nEntry : nFactor.entrySet()) {
            if (mFactor.containsKey(nEntry.getKey())) {
                int commonUsedCount = Math.min(nEntry.getValue(), mFactor.get(nEntry.getKey()));
                for (int i = 0; i < commonUsedCount; i++) {
                    answer *= nEntry.getKey();
                    if (answer >= MAX) {
                        answer %= MAX;
                        isFolded = true;
                    }
                }
            }
        }
        String formattedAnswer = String.valueOf(answer);
        if (isFolded) {
            for (int i = 0; i < 9 - formattedAnswer.length(); i++) {
                sb.append(0);
            }
        }
        sb.append(formattedAnswer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}