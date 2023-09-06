import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private final StringBuffer sb;
    private final List<String> root = new ArrayList<>();
    private final Map<String, Integer> index = new HashMap<>();
    private final Queue<Integer> topologicalQueue = new LinkedList<>();
    private int numberOfNode;
    private int numberOfEdge;
    private int[] precedence;
    private String[] node;
    private List<Integer>[] children;
    private List<Integer>[] descendant;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuffer();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        precedence = new int[numberOfNode];
        node = new String[numberOfNode];
        children = new ArrayList[numberOfNode];
        descendant = new ArrayList[numberOfNode];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfNode; i++) {
            node[i] = st.nextToken();
            children[i] = new ArrayList<>();
            descendant[i] = new ArrayList<>();
        }
        Arrays.sort(node);
        for (int i = 0; i < numberOfNode; i++) {
            index.put(node[i], i);
        }
        numberOfEdge = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            descendant[index.get(parent)].add(index.get(child));
            precedence[index.get(child)]++;
        }
        for (int i = 0; i < numberOfNode; i++) {
            if (precedence[i] == 0) {
                topologicalQueue.offer(i);
                root.add(node[i]);
            }
        }
    }

    private void topologicalSort() {
        while (!topologicalQueue.isEmpty()) {
            int current = topologicalQueue.poll();
            for (int child : descendant[current]) {
                precedence[child]--;
                if (precedence[child] == 0) {
                    children[current].add(child);
                    topologicalQueue.offer(child);
                }
            }
        }
    }

    private void solve() {
        topologicalSort();
        sb.append(root.size()).append("\n");
        for (int i = 0; i < root.size(); i++) {
            sb.append(root.get(i)).append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < numberOfNode; i++) {
            sb.append(node[i]).append(" ");
            sb.append(children[i].size()).append(" ");
            children[i].sort(Comparator.naturalOrder());
            for (int j = 0; j < children[i].size(); j++) {
                sb.append(node[children[i].get(j)]).append(" ");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}