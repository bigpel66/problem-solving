import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int size;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws IOException {
        size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
    }

    void solve() throws IOException {
        for (int i = 0; i < size - 1; i++) {
            pq.poll();
        }
        bw.write(Integer.valueOf(pq.poll()).toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}