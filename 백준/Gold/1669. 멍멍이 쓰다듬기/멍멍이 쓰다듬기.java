import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private int begin, end;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        begin = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    private int getAnswer() {
        int step = 1;
        int diff = end - begin;
        while ((long) step * (long) step < diff) {
            step++;
        }
        if (step * step != diff) {
            step--;
        }
        int answer = 2 * step - 1;
        diff -= step * step;
        while (diff > 0) {
            diff -= Math.min(step, diff);
            answer++;
        }
        return answer;
    }

    private void solve() {
        if (begin == end) {
            sb.append(0);
        } else {
            sb.append(getAnswer());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}