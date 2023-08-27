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
    int numberOfNode, beginIndex, range, answer;
    boolean[] isVisited;
    List<Integer>[] node;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        beginIndex = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        answer = 0;
        isVisited = new boolean[numberOfNode + 1];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }
    }

    int dfs(int index) {
        int depth = 0;
        isVisited[index] = true;
        for (int next : node[index]) {
            if (isVisited[next]) {
                continue;
            }
            depth = Math.max(depth, dfs(next));
        }
        if (depth >= range) {
            answer++;
        }
        return depth + 1;
    }

    void solve() {
        dfs(beginIndex);
        sb.append(Math.max(answer * 2 - 2, 0));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}