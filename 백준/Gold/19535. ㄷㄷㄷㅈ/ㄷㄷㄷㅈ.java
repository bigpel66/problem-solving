import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int numberOfNode;
    long dCount, gCount;
    private boolean[] isVisited;
    private List<Integer>[] node;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            getInput(br);
            sb = new StringBuffer();
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        dCount = 0;
        gCount = 0;
        isVisited = new boolean[numberOfNode + 1];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 1; i < numberOfNode; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }
    }

    private void getDCount() {
        for (int i = 1; i <= numberOfNode; i++) {
            long curEdge = node[i].size();
            for (int child : node[i]) {
                if (isVisited[child]) {
                    continue;
                }
                long connectedEdge = node[child].size();
                dCount += (curEdge - 1) * (connectedEdge - 1);
            }
            isVisited[i] = true;
        }
    }

    private void getGCount() {
        for (int i = 1; i <= numberOfNode; i++) {
            long edgeCount = node[i].size();
            if (edgeCount >= 3) {
                gCount += edgeCount * (edgeCount - 1) * (edgeCount - 2) / 6;
            }
        }
    }

    private void solve() {
        getDCount();
        getGCount();
        if (dCount > gCount * 3) {
            sb.append("D");
        } else if (dCount < gCount * 3) {
            sb.append("G");
        } else if (dCount == gCount * 3) {
            sb.append("DUDUDUNGA");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}