import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int numberOfNode, answer;
    private long targetIteration;
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
        numberOfNode = Integer.parseInt(br.readLine());
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 1; i <= numberOfNode; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            node[i].add(new Node(left, right));
        }
        targetIteration = Long.parseLong(br.readLine());
    }

    private void dfs(int cur, long k) {
        for (Node child : node[cur]) {
            int left = child.left;
            int right = child.right;
            if (left == -1 && right == -1) {
                answer = cur;
                return;
            } else if (left != -1 && right != -1) {
                if (k % 2 == 1L) {
                    dfs(left, k / 2 + 1);
                } else {
                    dfs(right, k / 2);
                }
            } else if (left == -1) {
                dfs(right, k);
            } else if (right == -1) {
                dfs(left, k);
            }
        }
    }

    private void solve() {
        dfs(1, targetIteration);
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    private class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}