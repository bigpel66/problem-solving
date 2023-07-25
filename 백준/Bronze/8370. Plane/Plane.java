import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Integer i1, i2, i3, i4;

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        i1 = Integer.parseInt(st.nextToken());
        i2 = Integer.parseInt(st.nextToken());
        i3 = Integer.parseInt(st.nextToken());
        i4 = Integer.parseInt(st.nextToken());
    }

    void solve() throws Exception {
        bw.write(Integer.valueOf(i1 * i2 + i3 * i4).toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}