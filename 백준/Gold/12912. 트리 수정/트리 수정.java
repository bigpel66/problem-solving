import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private final StringBuffer sb;
    private long diameter, maxValue;
    private int numberOfNode, maxValueIndex;
    private Node[] edge;
    private List<Node>[] node;
    private boolean[] isVisited;

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
        diameter = Long.MIN_VALUE;
        numberOfNode = Integer.parseInt(br.readLine());
        edge = new Node[numberOfNode - 1];
        node = new ArrayList[numberOfNode];
        for (int i = 0; i < numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfNode - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            edge[i] = new Node(u, v, cost);
            node[u].add(new Node(u, v, cost));
            node[v].add(new Node(v, u, cost));
        }
    }

    private void dfs(int cur, long acc) {
        isVisited[cur] = true;
        if (maxValue < acc) {
            maxValue = acc;
            maxValueIndex = cur;
        }
        for (Node next : node[cur]) {
            if (isVisited[next.to]) {
                continue;
            }
            int to = next.to;
            long cost = next.cost;
            dfs(to, acc + cost);
        }
    }

    private long treeDiameter(int entrypoint, int exceptIndex) {
        maxValueIndex = -1;
        isVisited = new boolean[numberOfNode];
        isVisited[exceptIndex] = true;
        maxValue = Long.MIN_VALUE;
        dfs(entrypoint, 0L);
        isVisited = new boolean[numberOfNode];
        isVisited[exceptIndex] = true;
        maxValue = Long.MIN_VALUE;
        dfs(maxValueIndex, 0L);
        return maxValue;
    }

    private void solve() {
        for (int i = 0; i < edge.length; i++) {
            Node cur = edge[i];
            int from = cur.from;
            int to = cur.to;
            long cost = cur.cost;
            long d1 = treeDiameter(from, to);
            long d2 = treeDiameter(to, from);
            diameter = Math.max(diameter, d1 + d2 + cost);
        }
        sb.append(diameter);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    private class Node {
        public int from;
        public int to;
        public long cost;

        public Node(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}