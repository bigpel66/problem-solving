import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    BigInteger total;
    BigInteger diff;
    BigInteger two;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        total = new BigInteger(br.readLine());
        diff = new BigInteger(br.readLine());
        two = new BigInteger("2");
    }

    void solve() {
        BigInteger klaudia = (total.subtract(diff)).divide(two).add(diff);
        BigInteger natalia = (total.subtract(diff)).divide(two);
        sb.append(klaudia).append("\n").append(natalia);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}