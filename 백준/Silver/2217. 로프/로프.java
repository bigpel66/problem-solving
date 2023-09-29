import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    private final StringBuilder sb;
    private int numberOfRope, answer;
    private int[] rope;

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
        numberOfRope = Integer.parseInt(br.readLine());
        answer = Integer.MIN_VALUE;
        rope = new int[numberOfRope];
        for (int i = 0; i < numberOfRope; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
    }

    private void solve() {
        for (int i = numberOfRope - 1; i >= 0; i--) {
            answer = Math.max(answer, rope[i] * (numberOfRope - i));
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}