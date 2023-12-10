import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private BigInteger a, b;

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
        a = new BigInteger(st.nextToken());
        b = new BigInteger(st.nextToken());
    }

    private void solve() {
        sb.append(a.add(b));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
