import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private long l1, l2, w1, w2;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            int numberOfTest = Integer.parseInt(br.readLine());
            while (numberOfTest-- > 0) {
                getInput(br);
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        l1 = Long.parseLong(st.nextToken());
        w1 = Long.parseLong(st.nextToken());
        l2 = Long.parseLong(st.nextToken());
        w2 = Long.parseLong(st.nextToken());
    }

    private void solve() {
        long s1 = l1 * w1;
        long s2 = l2 * w2;
        if (s1 > s2) {
            sb.append("TelecomParisTech\n");
        } else if (s1 < s2) {
            sb.append("Eurecom\n");
        } else {
            sb.append("Tie\n");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}