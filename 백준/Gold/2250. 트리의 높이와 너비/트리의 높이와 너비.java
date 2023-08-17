import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfNode, rootIndex, maxLevel, increment;
    int[] minPlace, maxPlace;
    Node[] node;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        maxLevel = increment = 0;
        node = new Node[numberOfNode + 1];
        minPlace = new int[numberOfNode + 1];
        maxPlace = new int[numberOfNode + 1];
        boolean[] isVisited = new boolean[numberOfNode + 1];
        for (int i = 1; i <= numberOfNode; i++) {
            minPlace[i] = numberOfNode;
            maxPlace[i] = 0;
            node[i] = new Node(i);
        }
        for (int i = 1; i <= numberOfNode; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int self = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            node[self].left = left;
            node[self].right = right;
            if (left != -1 && !isVisited[left]) {
                isVisited[left] = true;
            }
            if (right != -1 && !isVisited[right]) {
                isVisited[right] = true;
            }
        }
        for (int i = 1; i <= numberOfNode; i++) {
            if (!isVisited[i]) {
                rootIndex = i;
                break;
            }
        }
    }

    void inorderTraverse(int index, int level) {
        node[index].level = level;
        maxLevel = Math.max(maxLevel, level);
        if (node[index].left != -1) {
            inorderTraverse(node[index].left, level + 1);
        }
        node[index].place = ++increment;
        minPlace[level] = Math.min(minPlace[level], increment);
        maxPlace[level] = Math.max(minPlace[level], increment);
        if (node[index].right != -1) {
            inorderTraverse(node[index].right, level + 1);
        }
    }

    void solve() {
        inorderTraverse(rootIndex, 1);
        int floor = maxLevel;
        int width = -1;
        for (int i = 1; i <= maxLevel; i++) {
            int diff = maxPlace[i] - minPlace[i] + 1;
            if (width < diff) {
                width = diff;
                floor = i;
            }
        }
        sb.append(floor).append(' ').append(width);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public class Node {

        int self;
        int left;
        int right;
        int place;
        int level;

        public Node(int self) {
            this.self = self;
            this.left = -1;
            this.right = -1;
            this.place = -1;
            this.level = -1;
        }

    }

}