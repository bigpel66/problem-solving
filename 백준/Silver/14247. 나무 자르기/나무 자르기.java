import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private long answer;
    private int numberOfTree;
    private int[] increment;

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
        answer = 0;
        numberOfTree = Integer.parseInt(br.readLine());
        increment = new int[numberOfTree];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfTree; i++) {
            answer += Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfTree; i++) {
            increment[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        Arrays.sort(increment);
        for (int i = 0; i < numberOfTree; i++) {
            answer += (long) i * increment[i];
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}