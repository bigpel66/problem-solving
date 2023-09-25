import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private int gcd, answerA, answerB;
    private long mul;

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
        gcd = Integer.parseInt(st.nextToken());
        mul = (long) gcd * Integer.parseInt(st.nextToken());
    }

    private int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

    private void solve() {
        for (int i = gcd; i <= Math.sqrt(mul); i += gcd) {
            if (mul % i == 0 && getGcd(i, (int) (mul / i)) == gcd) {
                answerA = i;
                answerB = (int) (mul / i);
            }
        }
        sb.append(answerA).append(" ").append(answerB);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}