import java.io.*;
import java.util.*;


public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfTest;
    int numberOfNode;
    int rootIndex;
    int targetA, targetB;
    List<Integer>[] node;
    int[] parentRecord, levelRecord;

    public Main() throws Exception {
        numberOfTest = Integer.parseInt(br.readLine());
        while (numberOfTest-- > 0) {
            getInput();
            solve();
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private void getInput() throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        node = new ArrayList[numberOfNode + 1];
        parentRecord = new int[numberOfNode + 1];
        levelRecord = new int[numberOfNode + 1];
        for (int i = 1; i <= numberOfNode; i++) {
            node[i] = new ArrayList<>();
        }
        boolean[] isVisited = new boolean[numberOfNode + 1];
        for (int i = 0; i < numberOfNode - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            node[parent].add(child);
            node[child].add(parent);
            isVisited[child] = true;
        }
        for (int i = 1; i <= numberOfNode; i++) {
            if (!isVisited[i]) {
                rootIndex = i;
                break;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        targetA = Integer.parseInt(st.nextToken());
        targetB = Integer.parseInt(st.nextToken());
    }

    private void analyzeStructure(int index, int level, int parent) {
        levelRecord[index] = level;
        parentRecord[index] = parent;
        for (int next : node[index]) {
            if (next != parent) {
                analyzeStructure(next, level + 1, index);
            }
        }
    }

    private int getNearestCommonAncestor() {
        int targetALevel = levelRecord[targetA];
        int targetBLevel = levelRecord[targetB];
        while (targetALevel > targetBLevel) {
            targetA = parentRecord[targetA];
            targetALevel--;
        }
        while (targetALevel < targetBLevel) {
            targetB = parentRecord[targetB];
            targetBLevel--;
        }
        while (targetA != targetB) {
            targetA = parentRecord[targetA];
            targetB = parentRecord[targetB];
        }
        return targetA;
    }

    private void solve() {
        analyzeStructure(rootIndex, 1, 0);
        sb.append(getNearestCommonAncestor()).append('\n');
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}