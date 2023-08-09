import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int numberOfSequence;
    int[] sequence;
    PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.naturalOrder());
    StringBuffer sb = new StringBuffer();

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        numberOfSequence = Integer.parseInt(br.readLine());
        sequence = new int[numberOfSequence];
        for (int i = 0; i < numberOfSequence; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
    }

    void solve() {
        for (int i = 0; i < numberOfSequence; i++) {
            if (i % 2 == 0) {
                min.offer(sequence[i]);
            } else {
                max.offer(sequence[i]);
            }
            if (!max.isEmpty() && max.peek() < min.peek()) {
                int maxPeek = max.poll();
                int minPeek = min.poll();
                min.offer(maxPeek);
                max.offer(minPeek);
            }
            sb.append(min.peek());
            sb.append('\n');
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}