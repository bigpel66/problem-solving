import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int numberOfNode;
    private List<Integer>[] node;
    private long[] dp;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            getInput(br);
            sb = new StringBuffer();
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        node = new ArrayList[numberOfNode + 1];
        dp = new long[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 2; i <= numberOfNode; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            if ("W".equals(type)) {
                amount *= -1;
            }
            dp[i] = amount;
            node[i].add(target);
            node[target].add(i);
        }
    }

    private void dfs(int cur, int prev) {
        for (int child : node[cur]) {
            if (child == prev) {
                continue;
            }
            dfs(child, cur);
        }
        if (prev == -1) {
            return;
        }
        if (dp[cur] > 0) {
            dp[prev] += dp[cur];
        }
    }

    private void solve() {
        dfs(1, -1);
        sb.append(dp[1]);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}