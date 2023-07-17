import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BigInteger i1, i2;

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        i1 = new BigInteger(st.nextToken());
        i2 = new BigInteger(st.nextToken());
    }

    void solve() throws IOException {
        bw.write(i1.divide(i2).toString() + '\n');
        bw.write(i1.mod(i2).toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}