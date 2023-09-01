import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int numberOfNode, numberOfQuery;
    private int[] parent;
    private int[] depth;
    private List<Integer>[] node;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            getInput(br);
            sb = new StringBuffer();
            solve(br);
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        parent = new int[numberOfNode + 1];
        depth = new int[numberOfNode + 1];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 1; i <= numberOfNode - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }
        numberOfQuery = Integer.parseInt(br.readLine());
    }

    private void getDepth(int cur, int prev) {
        parent[cur] = prev;
        depth[cur] = depth[prev] + 1;
        for (int next : node[cur]) {
            if (next == prev) {
                continue;
            }
            getDepth(next, cur);
        }
    }

    private int getLeastCommonAncestor(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        while (depth[u] != depth[v]) {
            u = parent[u];
        }
        while (u != v) {
            u = parent[u];
            v = parent[v];
        }
        return u;
    }

    private void solve(BufferedReader br) throws Exception {
        getDepth(1, 0);
        for (int i = 0; i < numberOfQuery; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(getLeastCommonAncestor(u, v)).append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}