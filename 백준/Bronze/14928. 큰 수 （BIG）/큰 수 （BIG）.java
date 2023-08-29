import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final StringBuffer sb;
    String s;
    int mod;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            getInput(br);
            sb = new StringBuffer();
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        s = br.readLine();
    }

    private void solve() {
        for (int i = 0; i < s.length(); i++) {
            mod = (mod * 10 + (s.charAt(i) - '0')) % 20000303;
        }
        sb.append(mod);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}