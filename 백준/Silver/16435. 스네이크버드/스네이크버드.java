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
    private int numberOfFruit, curr;
    private List<Integer> heights = new ArrayList<>();
    ;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfFruit = Integer.parseInt(st.nextToken());
        curr = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfFruit; i++) {
            heights.add(Integer.parseInt(st.nextToken()));
        }
        heights.sort(Comparator.naturalOrder());
    }

    private void solve() {
        for (int height : heights) {
            if (curr >= height) {
                curr++;
            }
        }
        sb.append(curr);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}