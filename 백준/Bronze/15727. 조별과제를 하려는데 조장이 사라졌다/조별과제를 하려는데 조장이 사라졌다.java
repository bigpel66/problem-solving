import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final StringBuffer sb;
    private int distance;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            getInput(br);
            sb = new StringBuffer();
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        distance = Integer.parseInt(br.readLine());
    }

    private void solve() {
        sb.append((int) Math.ceil((double) distance / 5));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}