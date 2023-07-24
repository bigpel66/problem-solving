import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    Integer floor;

    public Main() throws Exception {
        while (getInput()) {
            solve();
        }
        bw.write(sb.toString());
        bw.flush();
    }

    boolean getInput() throws Exception {
        floor = Integer.parseInt(br.readLine());
        return floor != 0;
    }

    void solve() throws Exception {
        Integer value = floor * (floor + 1) / 2;
        sb.append(value.toString() + '\n');
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}