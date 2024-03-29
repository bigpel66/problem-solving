import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfBook, maxWeight, answer;
    private List<Integer> weights = new ArrayList<>();

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
        numberOfBook = Integer.parseInt(st.nextToken());
        maxWeight = Integer.parseInt(st.nextToken());
        if (numberOfBook != 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < numberOfBook; i++) {
            weights.add(Integer.parseInt(st.nextToken()));
        }
    }

    private void solve() {
        int acc = 0;
        for (int weight : weights) {
            if (acc + weight <= maxWeight) {
                acc += weight;
            } else {
                acc = weight;
                answer++;
            }
        }
        sb.append(numberOfBook == 0 ? answer : answer + 1);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}