import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private final StringBuilder sb;
    private int numberOfProduct, answer;
    private List<Integer> price = new ArrayList<>();

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
        numberOfProduct = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfProduct; i++) {
            price.add(Integer.parseInt(br.readLine()));
        }
        price.sort(Comparator.reverseOrder());
    }

    private void solve() {
        for (int i = 0; i < numberOfProduct; i++) {
            if ((i + 1) % 3 == 0) {
                continue;
            }
            answer += price.get(i);
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}