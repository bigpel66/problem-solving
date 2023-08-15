import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfNode, targetNode, targetIndex, count;
    int[] node, parentRecord;

    public Main() throws Exception {
        while (getInput()) {
            solve();
        }
        bw.write(sb.toString());
        bw.flush();
    }

    boolean getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        targetNode = Integer.parseInt(st.nextToken());
        count = 0;
        if (numberOfNode == 0 && targetNode == 0) {
            return false;
        }
        node = new int[numberOfNode + 1];
        parentRecord = new int[numberOfNode + 1];
        st = new StringTokenizer(br.readLine());
        int index = -1;
        node[0] = -1;
        parentRecord[0] = -1;
        for (int i = 1; i <= numberOfNode; i++) {
            node[i] = Integer.parseInt(st.nextToken());
            if (targetNode == node[i]) {
                targetIndex = i;
            }
            if (node[i - 1] + 1 != node[i]) {
                index++;
            }
            parentRecord[i] = index;
        }
        return true;
    }

    void solve() {
        int targetParent = parentRecord[targetIndex];
        int targetGrandParent = parentRecord[targetParent];
        for (int i = 1; i <= numberOfNode; i++) {
            int parent = parentRecord[i];
            int grandeParent = parentRecord[parent];
            if (parent != targetParent && grandeParent == targetGrandParent) {
                count++;
            }
        }
        sb.append(count).append('\n');
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}