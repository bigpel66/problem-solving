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
    private int[] ball;
    private int[] indegree;
    private List<Integer>[] node;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuffer();
            while (getInput(br)) {
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private boolean getInput(BufferedReader br) throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        answer = 0;
        if (numberOfNode == 0) {
            return false;
        }
        ball = new int[numberOfNode + 1];
        indegree = new int[numberOfNode + 1];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfNode; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            ball[u] = Integer.parseInt(st.nextToken());
            int numberOfChild = Integer.parseInt(st.nextToken());
            for (int j = 0; j < numberOfChild; j++) {
                int v = Integer.parseInt(st.nextToken());
                indegree[v]++;
                node[u].add(v);
            }
        }
        return true;
    }

    private int dfs(int cur) {
        int count = ball[cur] - 1;
        for (int next : node[cur]) {
            count += dfs(next);
        }
        answer += Math.abs(count);
        return count;
    }

    private void solve() {
        for (int i = 1; i <= numberOfNode; i++) {
            if (indegree[i] == 0) {
                dfs(i);
            }
        }
        sb.append(answer).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}