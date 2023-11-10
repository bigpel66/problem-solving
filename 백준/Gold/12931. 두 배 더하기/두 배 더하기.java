import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int size, sum, count;
    private final List<Integer> array = new ArrayList<>();

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
        size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            array.add(Integer.parseInt(st.nextToken()));
        }
        sum = array.stream().reduce(0, Integer::sum);
        count = 0;
    }

    private void solve() {
        while (sum != 0) {
            int increment = 0;
            for (int i = 0; i < size; i++) {
                if (array.get(i) % 2 == 1) {
                    array.set(i, array.get(i) - 1);
                    increment++;
                }
            }
            if (increment > 0) {
                sum -= increment;
                count += increment;
            } else {
                for (int i = 0; i < size; i++) {
                    array.set(i, array.get(i) / 2);
                }
                sum /= 2;
                count++;
            }
        }
        sb.append(count);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}