import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int maxNumber, targetIndex;
    private boolean[] isVisited;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuffer();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxNumber = Integer.parseInt(st.nextToken());
        targetIndex = Integer.parseInt(st.nextToken());
        isVisited = new boolean[maxNumber + 1];
    }

    private int findTargetIndex() {
        for (int i = 2; i <= maxNumber; i++) {
            for (int j = i; j <= maxNumber; j += i) {
                if (isVisited[j]) {
                    continue;
                }
                isVisited[j] = true;
                targetIndex--;
                if (targetIndex == 0) {
                    return j;
                }
            }
        }
        return -1;
    }

    private void solve() {
        sb.append(findTargetIndex());
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}