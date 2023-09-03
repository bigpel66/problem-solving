import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfNode;
    int [][] dp;
    List<Integer>[] node;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        dp = new int[numberOfNode + 1][2];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < numberOfNode - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }
    }

    int dfs(int cur, int prev, int isSelected) {
        if (dp[cur][isSelected] != -1) {
            return dp[cur][isSelected];
        }
        dp[cur][isSelected] = isSelected == 1 ? 1 : 0;
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

    void solve() {
        sb.append(Math.min(dfs(1, -1, 1), dfs(1, -1, 0)));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}