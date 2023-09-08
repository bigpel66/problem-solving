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
    private int[] people;
    private int[][] dp;
    private List<Integer>[] node;

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
        people = new int[numberOfNode + 1];
        dp = new int[numberOfNode + 1][2];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            Arrays.fill(dp[i], -1);
            node[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfNode; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
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
        dp[cur][isSelected] = isSelected == 0 ? 0 : people[cur];
        for (int next : node[cur]) {
            if (next == prev) {
                continue;
            }
            if (isSelected == 1) {
                dp[cur][1] += dfs(next, cur, 0);
            } else {
                dp[cur][0] += Math.max(dfs(next, cur, 0), dfs(next, cur, 1));
            }
        }
        return dp[cur][isSelected];
    }

    private void solve() {
        sb.append(Math.max(dfs(1, -1, 0), dfs(1, -1, 1)));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}
