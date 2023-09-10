import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private final StringBuffer sb;
    private int numberOfNode;
    private boolean[] isVisited;
    private int[] weight;
    private int[][] dp;
    private List<Integer>[] node;
    private List<Integer> path = new ArrayList<>();

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
        numberOfNode = Integer.parseInt(br.readLine());
        isVisited = new boolean[numberOfNode + 1];
        weight = new int[numberOfNode + 1];
        dp = new int[numberOfNode + 1][2];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            Arrays.fill(dp[i], -1);
            node[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfNode; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }
    }

    private void dfs(int cur, int prev) {
        dp[cur][0] = 0;
        dp[cur][1] = weight[cur];
        for (int next : node[cur]) {
            if (next == prev) {
                continue;
            }
            dfs(next, cur);
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
            dp[cur][1] += dp[next][0];
        }
    }

    private void trace(int cur, int prev) {
        if (dp[cur][1] > dp[cur][0] && !isVisited[prev]) {
            path.add(cur);
            isVisited[cur] = true;
        }
        for (int next : node[cur]) {
            if (next == prev) {
                continue;
            }
            trace(next, cur);
        }
    }

    private void solve() {
        dfs(1, 0);
        trace(1, 0);
        sb.append(Math.max(dp[1][0], dp[1][1])).append("\n");
        path.sort(Comparator.naturalOrder());
        for (int i : path) {
            sb.append(i).append(" ");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}