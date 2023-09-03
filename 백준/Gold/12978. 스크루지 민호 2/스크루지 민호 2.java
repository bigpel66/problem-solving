import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int numberOfNode;
    private int[][] dp;
    private List<Integer>[] node;

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
        dp = new int[numberOfNode + 1][2];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            Arrays.fill(dp[i], -1);
            node[i] = new ArrayList<>();
        }
        for (int i = 1; i <= numberOfNode - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }
    }

    private int dfs(int cur, int prev, int isSelected) {
        if (dp[cur][isSelected] != -1) {
            return dp[cur][isSelected];
        }
        dp[cur][isSelected] = isSelected == 0 ? 0 : 1;
        for (int next : node[cur]) {
            if (prev == next) {
                continue;
            }
            if (isSelected == 0) {
                dp[cur][isSelected] += dfs(next, cur, 1);
            } else {
                dp[cur][isSelected] += Math.min(dfs(next, cur, 0), dfs(next, cur, 1));
            }
        }
        return dp[cur][isSelected];
    }

    private void solve() {
        sb.append(Math.min(dfs(1, -1, 0), dfs(1, -1, 1)));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}