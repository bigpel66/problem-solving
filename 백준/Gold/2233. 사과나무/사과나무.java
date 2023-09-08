import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int numberOfNode, child1, child2;
    private char[] appleTree;
    private int[] parent;
    private int[] depth;
    private int[] index;

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
        appleTree = br.readLine().toCharArray();
        parent = new int[numberOfNode + 1];
        depth = new int[numberOfNode + 1];
        index = new int[numberOfNode * 2 + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        child1 = Integer.parseInt(st.nextToken());
        child2 = Integer.parseInt(st.nextToken());
    }

    private void getHint() {
        int cur = 1;
        int prev = 0;
        for (int i = 0; i < appleTree.length; i++) {
            if (appleTree[i] == '0') {
                parent[cur] = prev;
                depth[cur] = depth[prev] + 1;
                index[i + 1] = cur;
                prev = cur++;
            } else {
                index[i + 1] = prev;
                prev = parent[prev];
            }
        }
    }

    private int lca() {
        if (depth[child1] < depth[child2]) {
            int temp = child2;
            child2 = child1;
            child1 = temp;
        }
        while (depth[child1] != depth[child2]) {
            child1 = parent[child1];
        }
        while (child1 != child2) {
            child1 = parent[child1];
            child2 = parent[child2];
        }
        return child1;
    }

    private void solve() {
        getHint();
        child1 = index[child1];
        child2 = index[child2];
        int target = lca();
        for (int i = 1; i <= numberOfNode * 2; i++) {
            if (index[i] == target) {
                sb.append(i).append(" ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}