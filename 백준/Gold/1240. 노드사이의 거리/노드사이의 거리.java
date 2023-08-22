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
    int numberOfNode, numberOfQuery, distance;
    boolean[] isVisited;
    Node[] node;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        numberOfQuery = Integer.parseInt(st.nextToken());
        node = new Node[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new Node();
        }
        for (int i = 1; i <= numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            node[u].children.add(v);
            node[u].costs.add(cost);
            node[v].children.add(u);
            node[v].costs.add(cost);
        }
    }

    boolean dfs(int index, int target, int acc) {
        if (index == target) {
            distance = acc;
            return true;
        }
        isVisited[index] = true;
        for (int i = 0; i < node[index].children.size(); i++) {
            int next = node[index].children.get(i);
            if (isVisited[next]) {
                continue;
            }
            if (dfs(next, target, acc + node[index].costs.get(i))) {
                return true;
            }
        }
        return false;
    }

    void solve() throws Exception {
        for (int i = 0; i < numberOfQuery; i++) {
            isVisited = new boolean[numberOfNode + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            dfs(from, to, 0);
            sb.append(distance).append('\n');
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public class Node {
        public List<Integer> children;
        public List<Integer> costs;

        public Node() {
            children = new ArrayList<>();
            costs = new ArrayList<>();
        }
    }

}