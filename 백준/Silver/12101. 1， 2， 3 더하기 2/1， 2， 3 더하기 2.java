import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int target, order;
    private List<String>[] expression;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    @SuppressWarnings("unchecked")
    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        expression = new ArrayList[11 + 1];
        for (int i = 0; i <= 11; i++) {
            expression[i] = new ArrayList<>();
        }
        expression[1].add("1");
        expression[2].add("1+1");
        expression[2].add("2");
        expression[3].add("1+1+1");
        expression[3].add("1+2");
        expression[3].add("2+1");
        expression[3].add("3");
    }

    private void solve() {
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= 3; j++) {
                for (String e : expression[i - j]) {
                    expression[i].add(e + "+" + j);
                }
            }
        }
        if (expression[target].size() < order) {
            sb.append(-1);
        } else {
            expression[target].sort(Comparator.naturalOrder());
            sb.append(expression[target].get(order - 1));
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}