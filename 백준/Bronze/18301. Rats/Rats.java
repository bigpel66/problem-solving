import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int n1, n2, n3;

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

    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken()) + 1;
        n2 = Integer.parseInt(st.nextToken()) + 1;
        n3 = Integer.parseInt(st.nextToken()) + 1;
    }

    private void solve() {
        sb.append((int) Math.floor((double) n1 * (double) n2 / (double) n3 - 1));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
