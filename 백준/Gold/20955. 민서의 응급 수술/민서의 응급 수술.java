import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfNode, numberOfEdge, numberOfOperation;
    int[] parent;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        numberOfEdge = Integer.parseInt(st.nextToken());
        numberOfOperation = 0;
        parent = new int[numberOfNode + 1];
        for (int i = 0; i <= numberOfNode; i++) {
            parent[i] = i;
        }
    }

    int find_parent(int index) {
        if (index == parent[index]) {
            return index;
        }
        return parent[index] = find_parent(parent[index]);
    }

    void union_parent(int index1, int index2) {
        index1 = find_parent(index1);
        index2 = find_parent(index2);
        if (index1 == index2) {
            return;
        }
        if (index1 < index2) {
            parent[index2] = index1;
        } else {
            parent[index1] = index2;
        }
    }

    boolean is_same_parent(int index1, int index2) {
        index1 = find_parent(index1);
        index2 = find_parent(index2);
        return index1 == index2;
    }

    void solve() throws Exception {
        for (int i = 1; i <= numberOfEdge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (is_same_parent(u, v)) {
                numberOfOperation++;
            } else {
                union_parent(u, v);
            }
        }
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i <= numberOfNode; i++) {
            int value = find_parent(i);
            s.add(value);
        }
        numberOfOperation += s.size() - 1;
        sb.append(numberOfOperation);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}