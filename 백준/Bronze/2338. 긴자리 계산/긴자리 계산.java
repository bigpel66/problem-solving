import java.io.*;
import java.math.BigInteger;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BigInteger i1, i2;

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws IOException {
        i1 = new BigInteger(br.readLine());
        i2 = new BigInteger(br.readLine());
    }

    void solve() throws IOException {
        bw.write(i1.add(i2).toString() + '\n');
        bw.write(i1.subtract(i2).toString() + '\n');
        bw.write(i1.multiply(i2).toString() + '\n');
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}