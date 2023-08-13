import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int rootIndex;
    int deleteIndex;
    int numberOfNode;
    int numberOfLeaf;
    int[] parent;
    boolean[] isVisited;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        numberOfLeaf = 0;
        parent = new int[numberOfNode];
        isVisited = new boolean[numberOfNode];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfNode; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) {
                rootIndex = i;
            }
        }
        deleteIndex = Integer.parseInt(br.readLine());
    }

    void deleteNode(int target) {
        parent[target] = -2;
        for (int i = 0; i < numberOfNode; i++) {
            if (parent[i] == target) {
                deleteNode(i);
            }
        }
    }

    void countLeafNode(int target) {
        boolean isLeaf = true;
        isVisited[target] = true;
        if (parent[target] == -2) {
            return;
        }
        for (int i = 0; i < numberOfNode; i++) {
            if (!isVisited[i] && parent[i] == target) {
                countLeafNode(i);
                isLeaf = false;
            }
        }
        if (isLeaf) {
            numberOfLeaf++;
        }
    }

    void solve() {
        if (deleteIndex == rootIndex) {
            sb.append(0);
        } else {
            deleteNode(deleteIndex);
            countLeafNode(rootIndex);
            sb.append(numberOfLeaf);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}