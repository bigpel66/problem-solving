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
    int numberOfDrop;
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
        numberOfDrop = Integer.parseInt(st.nextToken());
        node = new ArrayList[numberOfNode + 1];
        for (int i = 1; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            node[v1].add(v2);
            node[v2].add(v1);
        }
    }

    void solve() {
        int numberOfLeaf = 0;
        for (int i = 2; i <= numberOfNode; i++) {
            if (node[i].size() == 1) {
                numberOfLeaf++;
            }
        }
        sb.append((double) numberOfDrop / numberOfLeaf);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}