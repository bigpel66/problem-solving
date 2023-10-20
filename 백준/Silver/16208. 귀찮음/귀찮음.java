import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfPiece, totalLength;
    private long answer;
    private int[] stick;

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
        numberOfPiece = Integer.parseInt(br.readLine());
        totalLength = 0;
        answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        stick = new int[numberOfPiece];
        for (int i = 0; i < numberOfPiece; i++) {
            stick[i] = Integer.parseInt(st.nextToken());
            totalLength += stick[i];
        }
        Arrays.sort(stick);
    }


    private void solve() {
        for (int i = 0; i < numberOfPiece; i++) {
            int curr = stick[i];
            int remain = totalLength - curr;
            totalLength -= curr;
            answer += (long) curr * (long) remain;
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}