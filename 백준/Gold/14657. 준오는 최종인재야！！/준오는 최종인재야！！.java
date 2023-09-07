import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int numberOfNode, dayHourLimit, maxLevel, maxLevelIndex, minHour;
    private List<Node>[] node;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        dayHourLimit = Integer.parseInt(st.nextToken());
        maxLevel = maxLevelIndex = -1;
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            node[u].add(new Node(v, c));
            node[v].add(new Node(u, c));
        }
    }

    private void dfs(int cur, int prev, int count, int hour) {
        if (maxLevel < count) {
            maxLevel = count;
            maxLevelIndex = cur;
            minHour = hour;
        } else if (maxLevel == count && minHour > hour) {
            maxLevelIndex = cur;
            minHour = hour;
        }
        for (Node next : node[cur]) {
            if (next.index == prev) {
                continue;
            }
            int index = next.index;
            int cost = next.cost;
            dfs(index, cur, count + 1, hour + cost);
        }
    }

    private void solve() {
        dfs(1, -1, 0, 0);
        dfs(maxLevelIndex, -1, 0, 0);
        sb.append(minHour % dayHourLimit == 0 ? minHour / dayHourLimit : minHour / dayHourLimit + 1);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    private static class Node {
        public int index;
        public int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

}