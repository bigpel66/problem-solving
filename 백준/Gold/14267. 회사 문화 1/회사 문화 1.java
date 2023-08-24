import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfNode, numberOfApplause;
    int[] applause;
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
        numberOfApplause = Integer.parseInt(st.nextToken());
        applause = new int[numberOfNode + 1];
        node = new ArrayList[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            applause[i] = 0;
            node[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfNode; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                continue;
            }
            node[parent].add(i);
        }
        for (int i = 0; i < numberOfApplause; i++) {
            st = new StringTokenizer(br.readLine());
            int offset = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            applause[offset] += weight;
        }
    }

    void dfs(int index) {
        for (int next : node[index]) {
            applause[next] += applause[index];
            dfs(next);
        }
    }

    void solve() {
        dfs(1);
        for (int i = 1; i <= numberOfNode; i++) {
            sb.append(applause[i]).append(' ');
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}