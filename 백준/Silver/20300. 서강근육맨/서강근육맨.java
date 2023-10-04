import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private int numberOfMachine;
    private long[] stress;
    private long answer;

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
        numberOfMachine = Integer.parseInt(br.readLine());
        stress = new long[numberOfMachine];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfMachine; i++) {
            stress[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(stress);
    }

    private void solve() {
        numberOfMachine = stress.length % 2 == 1 ? numberOfMachine - 1 : numberOfMachine;
        answer = stress.length % 2 == 1 ? stress[stress.length - 1] : Long.MIN_VALUE;
        for (int i = 0; i < numberOfMachine; i++) {
            answer = Math.max(answer, stress[i] + stress[numberOfMachine - i - 1]);
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}