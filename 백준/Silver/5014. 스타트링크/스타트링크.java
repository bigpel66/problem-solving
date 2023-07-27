import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int height, begin, end, up, down;
    int[] count;
    Queue<Integer> q = new LinkedList<>();

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        begin = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        count = new int[height + 1];
    }

    boolean isReachable() {
        q.add(begin);
        count[begin] = 1;
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == end) {
                return true;
            }
            int upSide = current + up;
            int downSide = current - down;
            if (upSide <= height && count[upSide] == 0) {
                q.offer(upSide);
                count[upSide] = count[current] + 1;
            }
            if (downSide >= 1 && count[downSide] == 0) {
                q.offer(downSide);
                count[downSide] = count[current] + 1;
            }
        }
        return false;
    }

    void solve() throws IOException {
        if (isReachable()) {
            bw.write(Integer.valueOf(count[end] - 1).toString());
        } else {
            bw.write("use the stairs");
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}