import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private String s1, s2;
    private int zeroToOne, oneToZero;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            int numberOfTest = Integer.parseInt(br.readLine());
            while (numberOfTest-- > 0) {
                getInput(br);
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        s1 = st.nextToken();
        s2 = st.nextToken();
        zeroToOne = 0;
        oneToZero = 0;
    }

    private void solve() {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (s1.charAt(i) == '0') {
                zeroToOne++;
            } else {
                oneToZero++;
            }
        }
        sb.append(Math.max(zeroToOne, oneToZero)).append("\n");

    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}