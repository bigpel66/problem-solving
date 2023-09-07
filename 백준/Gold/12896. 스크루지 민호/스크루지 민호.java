import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int numberOfNode, maxLevel, maxLevelIndex;
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
        maxLevel = maxLevelIndex = -1;
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfNode - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }
    }

    private void dfs(int cur, int prev, int count) {
        if (maxLevel < count) {
            maxLevel = count;
            maxLevelIndex = cur;
        }
        for (int next : node[cur]) {
            if (next == prev) {
                continue;
            }
            dfs(next, cur, count + 1);
        }
    }

    private void solve() {
        dfs(1, -1, 0);
        dfs(maxLevelIndex, -1, 0);
        sb.append((maxLevel + 1) / 2);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}