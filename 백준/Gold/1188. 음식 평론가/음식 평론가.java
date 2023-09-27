import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private int numberOfSausage, numberOfCritics;

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
        numberOfSausage = Integer.parseInt(st.nextToken());
        numberOfCritics = Integer.parseInt(st.nextToken());
    }

    private int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

    private void solve() {
        int gcd = getGcd(numberOfSausage, numberOfCritics);
        int slicePerSausage = numberOfCritics / gcd - 1;
        sb.append(gcd * slicePerSausage);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}