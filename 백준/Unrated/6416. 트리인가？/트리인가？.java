import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    Map<Integer, Integer> node;
    int edge;
    int iteration;

    public Main() throws Exception {
        iteration = 1;
        while (true) {
            node = new HashMap<>();
            edge = 0;
            if (!getInput()) {
                break;
            }
            solve();
            iteration++;
        }
        bw.write(sb.toString());
        bw.flush();
    }

    boolean getInput() {
        while (true) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            if (parent < 0 && child < 0) {
                return false;
            } else if (parent == 0 && child == 0) {
                return true;
            }
            node.put(parent, node.getOrDefault(parent, 0));
            node.put(child, node.getOrDefault(child, 0) + 1);
            edge++;
        }
    }

    void solve() {
        if (edge == 0) {
            sb.append("Case ").append(iteration).append(" is a tree.\n");
            return;
        }
        int rootCandidates = 0;
        boolean isChildDuplicated = false;
        for (Map.Entry<Integer, Integer> entry : node.entrySet()) {
            int value = entry.getValue();
            if (value == 0) {
                rootCandidates++;
            } else if (value > 1) {
                isChildDuplicated = true;
            }
        }
        if (!isChildDuplicated && rootCandidates == 1 && edge == node.size() - 1) {
            sb.append("Case ").append(iteration).append(" is a tree.\n");
        } else {
            sb.append("Case ").append(iteration).append(" is not a tree.\n");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}