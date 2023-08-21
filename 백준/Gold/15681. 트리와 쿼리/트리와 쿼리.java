import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfNode, rootIndex, numberOfQuery;
    boolean[] isVisited;
    int[] subNode;
    List<Integer>[] node;

    public Main() throws Exception {
        getInput();
        solve(rootIndex);
        for (int i = 0; i < numberOfQuery; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(subNode[query]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        rootIndex = Integer.parseInt(st.nextToken());
        numberOfQuery = Integer.parseInt(st.nextToken());
        isVisited = new boolean[numberOfNode + 1];
        subNode = new int[numberOfNode + 1];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            subNode[i] = 0;
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

    void solve(int index) {
        isVisited[index] = true;
        if (rootIndex != index && node[index].size() == 1) {
            subNode[index] = 1;
            return;
        }
        for (int i = 0; i < node[index].size(); i++) {
            int next = node[index].get(i);
            if (isVisited[next]) {
                continue;
            }
            solve(next);
            subNode[index] += subNode[next];
        }
        subNode[index]++;
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}