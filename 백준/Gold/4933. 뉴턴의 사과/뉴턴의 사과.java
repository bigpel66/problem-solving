import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final int NIL = 0;
    private final StringBuffer sb;
    private String[] line;
    private int[][] parent;
    private Stack<Integer> stack;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberOfTest = Integer.parseInt(br.readLine());
            sb = new StringBuffer();
            while (numberOfTest-- > 0) {
                getInput(br);
                getHierarchy(0);
                getHierarchy(1);
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        line = new String[2];
        line[0] = br.readLine();
        line[1] = br.readLine();
        parent = new int[2][26 + 1];
        stack = new Stack<>();
    }

    private int tokenToInteger(String token) {
        if ("nil".equals(token)) {
            return NIL;
        }
        return token.charAt(0) - 'A' + 1;
    }

    private void getHierarchy(int index) {
        StringTokenizer st = new StringTokenizer(line[index]);
        while (true) {
            String token = st.nextToken();
            if ("end".equals(token)) {
                break;
            }
            int node = tokenToInteger(token);
            if (node != NIL && stack.size() >= 2) {
                int right = stack.pop();
                int left = stack.pop();
                parent[index][right] = parent[index][left] = node;
            }
            stack.push(node);
        }
        int top = stack.pop();
        parent[index][top] = top;
    }

    private void solve() {
        for (int i = 1; i <= 26; i++) {
            if (parent[0][i] != parent[1][i]) {
                sb.append("false\n");
                return;
            }
        }
        sb.append("true\n");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}