import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private final StringBuilder sb;
    private long answer;
    private int numberOfWaiting;
    private List<Integer> tip = new ArrayList<>();

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
        numberOfWaiting = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfWaiting; i++) {
            tip.add(Integer.parseInt(br.readLine()));
        }
        tip.sort(Comparator.reverseOrder());
    }

    private void solve() {
        for (int i = 0; i < numberOfWaiting; i++) {
            int cur = tip.get(i) - i;
            if (cur <= 0) {
                break;
            }
            answer += cur;
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}