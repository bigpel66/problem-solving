import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfCandy, numberOfBox, answer;
    private List<Integer> size;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            int numberOfTest = Integer.parseInt(br.readLine());
            while (numberOfTest-- > 0) {
                getInput(br);
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfCandy = Integer.parseInt(st.nextToken());
        numberOfBox = Integer.parseInt(st.nextToken());
        answer = 0;
        size = new ArrayList<>();
        for (int i = 0; i < numberOfBox; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            size.add(row * col);
        }
        size.sort(Comparator.reverseOrder());
    }


    private void solve() {
        for (int cur : size) {
            if (numberOfCandy <= 0) {
                sb.append(answer).append("\n");
                return;
            }
            answer++;
            numberOfCandy -= cur;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}