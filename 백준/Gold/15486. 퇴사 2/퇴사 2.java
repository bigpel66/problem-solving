import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int whenToQuit, max;
    private Consultant[] consultants;
    private int[] dp;

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
        whenToQuit = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        consultants = new Consultant[whenToQuit + 2];
        dp = new int[whenToQuit + 2];
        for (int i = 1; i <= whenToQuit; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int delay = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            consultants[i] = new Consultant(delay, reward);
        }
        consultants[whenToQuit + 1] = new Consultant(0, 0);
    }

    private void solve() {
        for (int i = 1; i <= whenToQuit + 1; i++) {
            max = Math.max(max, dp[i]);
            Consultant curr = consultants[i];
            if (i + curr.delay > whenToQuit + 1) {
                continue;
            }
            dp[i + curr.delay] = Math.max(dp[i + curr.delay], max + curr.reward);
        }
        sb.append(dp[whenToQuit + 1]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static final class Consultant {
        public int delay;
        public int reward;

        public Consultant(int delay, int reward) {
            this.delay = delay;
            this.reward = reward;
        }
    }
}
