import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final StringBuilder sb;
    private int numberOfProblem;
    private char[] color;

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
        numberOfProblem = Integer.parseInt(br.readLine());
        color = br.readLine().toCharArray();
    }

    private void solve() {
        int b = 0, r = 0;
        char cur = 0;
        for (int i = 0; i < numberOfProblem; i++) {
            if (color[i] == cur) {
                continue;
            }
            if (color[i] == 'B') {
                b++;
            } else if (color[i] == 'R') {
                r++;
            }
            cur = color[i];
        }
        sb.append(Math.min(b, r) + 1);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}