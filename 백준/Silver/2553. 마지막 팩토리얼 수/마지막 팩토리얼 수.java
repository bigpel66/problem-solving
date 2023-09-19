import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final StringBuilder sb;
    private int number;

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
        number = Integer.parseInt(br.readLine());
    }

    private void solve() {
        long answer = 1;
        for (int i = 1; i <= number; i++) {
            answer *= i;
            answer %= 1_000_000_000L;
            while (answer % 10 == 0) {
                answer /= 10;
            }
        }
        sb.append(answer % 10);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}