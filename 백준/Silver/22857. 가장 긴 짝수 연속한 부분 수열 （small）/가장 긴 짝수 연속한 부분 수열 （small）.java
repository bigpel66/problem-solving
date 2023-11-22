import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfSequence, chanceToRemove;
    private int[] sequence;
    private int[][] dp;

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
        numberOfSequence = Integer.parseInt(st.nextToken());
        chanceToRemove = Integer.parseInt(st.nextToken());
        sequence = new int[numberOfSequence + 1];
        dp = new int[numberOfSequence + 1][chanceToRemove + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfSequence; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        for (int index = 1; index <= numberOfSequence; index++) {
            for (int removed = 0; removed <= chanceToRemove; removed++) {
                if (sequence[index] % 2 == 0) {
                    dp[index][removed] = dp[index - 1][removed] + 1;
                } else if (removed != 0) {
                    dp[index][removed] = dp[index - 1][removed - 1];
                }
            }
        }
        Optional<Integer> max = Arrays.stream(dp).map(e -> e[chanceToRemove]).max(Comparator.naturalOrder());
        max.ifPresent(sb::append);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
