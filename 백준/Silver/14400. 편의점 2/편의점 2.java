import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private long answer;
    private int numberOfPoint;
    private int[] x;
    private int[] y;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfPoint = Integer.parseInt(st.nextToken());
        x = new int[numberOfPoint];
        y = new int[numberOfPoint];
        for (int i = 0; i < numberOfPoint; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            x[i] = p1;
            y[i] = p2;
        }
        Arrays.sort(x);
        Arrays.sort(y);
    }

    private void solve() {
        int conv1 = x[(numberOfPoint - 1) / 2];
        int conv2 = y[(numberOfPoint - 1) / 2];
        for (int i = 0; i < numberOfPoint; i++) {
            answer += Math.abs(x[i] - conv1);
            answer += Math.abs(y[i] - conv2);
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}