import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final StringBuilder sb;
    private String poly;

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
        poly = br.readLine();
    }

    private void solve() {
        poly = poly.replaceAll("XXXX", "AAAA");
        poly = poly.replaceAll("XX", "BB");
        if (poly.contains("X")) {
            sb.append(-1);
        } else {
            sb.append(poly);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}