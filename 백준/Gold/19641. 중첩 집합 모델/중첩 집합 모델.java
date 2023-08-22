import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfNode, rootIndex;
    int[][] subset;
    List<Integer>[] node;

    public Main() throws Exception {
        getInput();
        solve(rootIndex, 1);
        for (int i = 1; i <= numberOfNode; i++) {
            sb.append(i).append(' ').append(subset[i][0]).append(' ').append(subset[i][1]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        subset = new int[numberOfNode + 1][2];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 1; i <= numberOfNode; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                node[u].add(v);
            }
            node[u].sort(Comparator.naturalOrder());
        }
        rootIndex = Integer.parseInt(br.readLine());
    }

    int solve(int index, int order) {
        subset[index][0] = order;
        for (int next : node[index]) {
            if (subset[next][0] != 0) {
                continue;
            }
            order = solve(next, order + 1);
        }
        subset[index][1] = order + 1;
        return order + 1;
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}