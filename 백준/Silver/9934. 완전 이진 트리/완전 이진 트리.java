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
    List<List<Integer>> tree = new ArrayList<>();
    int[] node;
    int depth;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        depth = Integer.parseInt(br.readLine());
        for (int i = 0; i < depth; i++) {
            tree.add(new ArrayList<>());
        }
        int size = (int) Math.pow(2, depth) - 1;
        node = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }
    }

    void layer(int begin, int end, int current) {
        if (depth == current) {
            return;
        }
        int middle = (begin + end) / 2;
        tree.get(current).add(node[middle]);
        layer(begin, middle - 1, current + 1);
        layer(middle + 1, end, current + 1);
    }

    void solve() {
        layer(0, node.length - 1, 0);
        for (int i = 0; i < depth; i++) {
            List<Integer> level = tree.get(i);
            for (int j = 0; j < level.size(); j++) {
                sb.append(level.get(j)).append(' ');
            }
            sb.append('\n');
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}