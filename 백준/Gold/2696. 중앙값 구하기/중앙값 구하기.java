import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();
    int numberOfTest, numberOfSequence;

    public Main() throws Exception {
        getInput();
        while (numberOfTest-- != 0) {
            numberOfSequence = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> max = new PriorityQueue<>();
            PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
            solve(max, min);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws IOException {
        numberOfTest = Integer.parseInt(br.readLine());
    }

    void solve(PriorityQueue<Integer> max, PriorityQueue<Integer> min) throws Exception {
        int numberOfMedian = (numberOfSequence + 1) / 2;
        sb.append(Integer.valueOf(numberOfMedian).toString());
        for (int i = 0; i < numberOfSequence; i++) {
            if (i % 10 == 0) {
                st = new StringTokenizer(br.readLine());
            }
            int current = Integer.parseInt(st.nextToken());
            if (i % 2 == 0) {
                max.offer(current);
            } else {
                min.offer(current);
            }
            if (!max.isEmpty() && !min.isEmpty()) {
                if (max.peek() < min.peek()) {
                    int temp = max.poll();
                    max.add(min.poll());
                    min.add(temp);
                }
            }
            if (i % 2 == 0) {
                if (i % 20 == 0) {
                    sb.append('\n');
                } else {
                    sb.append(' ');
                }
                sb.append(Integer.valueOf(max.peek()).toString());
            }
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}