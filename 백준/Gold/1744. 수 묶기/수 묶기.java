import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Main {
    private final StringBuilder sb;
    private int numberOfSequence;
    private List<Integer> pos = new ArrayList<>();
    private List<Integer> neg = new ArrayList<>();

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
        numberOfSequence = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfSequence; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > 0) {
                pos.add(value);
            } else {
                neg.add(value);
            }
        }
        pos.sort(Comparator.reverseOrder());
        neg.sort(Comparator.naturalOrder());
    }

    private int makePairValue(List<Integer> list) {
        int i = 0;
        int sum = 0;
        while (i < list.size()) {
            if (i + 1 != list.size() && list.get(i) != 1 && list.get(i + 1) != 1) {
                sum += list.get(i++) * list.get(i++);
            } else {
                sum += list.get(i++);
            }
        }
        return sum;
    }

    private void solve() {
        int value = makePairValue(pos);
        value += makePairValue(neg);
        sb.append(value);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
