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
    int numberOfNode;
    int rootIndex;
    int pillar, toPillarLength, maxBranchLength;
    boolean[] isVisited;
    List<Node>[] node;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        rootIndex = Integer.parseInt(st.nextToken());
        isVisited = new boolean[numberOfNode + 1];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 1; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int v3 = Integer.parseInt(st.nextToken());
            node[v1].add(new Node(v2, v3));
            node[v2].add(new Node(v1, v3));
        }
    }

    void findPillar(int index, int length) {
        int edgeSize = node[index].size();
        if ((index == rootIndex && edgeSize > 1) || (index != rootIndex && (edgeSize == 1 || edgeSize > 2))) {
            pillar = index;
            toPillarLength = length;
            return;
        }
        for (int i = 0; i < edgeSize; i++) {
            Node next = node[index].get(i);
            if (isVisited[next.index]) {
                continue;
            }
            isVisited[next.index] = true;
            findPillar(next.index, length + next.cost);
        }
    }

    void findMaxBranch(int index, int length) {
        int edgeSize = node[index].size();
        if (edgeSize == 1) {
            maxBranchLength = Math.max(maxBranchLength, length);
            return;
        }
        for (int i = 0; i < edgeSize; i++) {
            Node next = node[index].get(i);
            if (isVisited[next.index]) {
                continue;
            }
            isVisited[next.index] = true;
            findMaxBranch(next.index, length + next.cost);
            isVisited[next.index] = false;
        }
    }

    void solve() {
        if (numberOfNode == 1) {
            sb.append("0 0");
            return;
        }
        isVisited[rootIndex] = true;
        findPillar(rootIndex, 0);
        findMaxBranch(pillar, 0);
        sb.append(toPillarLength).append(' ').append(maxBranchLength);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public class Node {

        public int index;
        public int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

    }

}