import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfFile;
    private PriorityQueue<Long> pq;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            int numberOfTest = Integer.parseInt(br.readLine());
            while (--numberOfTest >= 0) {
                getInput(br);
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        numberOfFile = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfFile; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
    }

    private void solve() {
        long answer = 0;
        while (pq.size() != 1) {
            long little1 = pq.poll();
            long little2 = pq.poll();
            long temp = little1 + little2;
            answer += temp;
            pq.offer(temp);
        }
        sb.append(answer).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}