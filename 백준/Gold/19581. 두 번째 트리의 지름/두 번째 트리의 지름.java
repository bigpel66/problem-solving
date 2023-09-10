import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private final StringBuffer sb;
    private long diameter, maxValue;
    private int numberOfNode, maxValueBeginIndex, maxValueEndIndex;
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
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 1; i <= numberOfNode - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            node[u].add(new Node(u, v, cost));
            node[v].add(new Node(v, u, cost));
        }
    }

    private void dfs(int cur, long acc) {
        isVisited[cur] = true;
        if (maxValue < acc) {
            maxValue = acc;
            maxValueEndIndex = cur;
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
        maxValueBeginIndex = maxValueEndIndex = -1;
        isVisited = new boolean[numberOfNode + 1];
        isVisited[exceptIndex] = true;
        maxValue = Long.MIN_VALUE;
        dfs(entrypoint, 0L);
        maxValueBeginIndex = maxValueEndIndex;
        isVisited = new boolean[numberOfNode + 1];
        isVisited[exceptIndex] = true;
        maxValue = Long.MIN_VALUE;
        dfs(maxValueBeginIndex, 0L);
        return maxValue;
    }

    private void solve() {
        treeDiameter(1, 0);
        int nonChangeableBegin = maxValueBeginIndex;
        int nonChangeableEnd = maxValueEndIndex;
        long dist1 = treeDiameter(nonChangeableBegin, nonChangeableEnd);
        long dist2 = treeDiameter(nonChangeableEnd, nonChangeableBegin);
        diameter = Math.max(dist1, dist2);
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