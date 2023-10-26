import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int numberOfStage, answer;
    private int[] levels;

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
        numberOfStage = Integer.parseInt(br.readLine());
        answer = 0;
        levels = new int[numberOfStage];
        for (int i = 0; i < numberOfStage; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }
    }

    private void solve() {
        int curr = levels[numberOfStage - 1];
        for (int i = numberOfStage - 2; i >= 0; i--) {
            if (curr > levels[i]) {
                curr = levels[i];
            } else {
                answer += levels[i] - (curr - 1);
                curr--;
            }
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}