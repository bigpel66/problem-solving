import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int numberOfTest;
    StringBuffer sb = new StringBuffer();

    public Main() throws Exception {
        getInput();
        while (numberOfTest-- != 0) {
            solve();
        }
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        numberOfTest = Integer.parseInt(br.readLine());
    }

    void solve() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long l1 = Long.parseLong(st.nextToken());
        Long l2 = Long.parseLong(st.nextToken());
        sb.append(l1 + l2);
        sb.append('\n');
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}