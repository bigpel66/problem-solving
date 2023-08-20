import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfNode, count;
    boolean[] isVisited;
    List<Integer>[] node;

    public Main() throws Exception {
        getInput();
        solve(1, 0);
        if (count % 2 == 0) {
            sb.append("No");
        } else {
            sb.append("Yes");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        count = 0;
        isVisited = new boolean[numberOfNode + 1];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i < numberOfNode + 1; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfNode - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }
    }

    void solve(int index, int step) {
        if (index != 1 && node[index].size() == 1) {
            count += step;
        }
        isVisited[index] = true;
        for (int next : node[index]) {
            if (isVisited[next]) {
                continue;
            }
            solve(next, step + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}