import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    List<Node>[] node = new ArrayList[DEFAULT_SIZE + 1];
    boolean isInit = false;
    boolean[] isVisited;
    int offset, value;

    private static final int DEFAULT_SIZE = 10_000;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        for (int i = 0; i <= DEFAULT_SIZE; i++) {
            node[i] = new ArrayList<>();
        }
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            isInit = true;
            StringTokenizer st = new StringTokenizer(line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            node[u].add(new Node(u, v, cost));
            node[v].add(new Node(v, u, cost));
        }
        offset = 1;
        value = Integer.MIN_VALUE;
    }

    void dfs(int index, int dist) {
        if (value < dist) {
            value = dist;
            offset = index;
        }
        isVisited[index] = true;
        List<Node> cur = node[index];
        for (Node n : cur) {
            if (isVisited[n.to]) {
                continue;
            }
            dfs(n.to, dist + n.cost);
        }
    }

    void solve() {
        if (!isInit) {
            sb.append(0);
            return;
        }
        isVisited = new boolean[DEFAULT_SIZE + 1];
        dfs(1, 0);
        isVisited = new boolean[DEFAULT_SIZE + 1];
        dfs(offset, 0);
        sb.append(value);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public class Node {
        public int from;
        public int to;
        public int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }


}