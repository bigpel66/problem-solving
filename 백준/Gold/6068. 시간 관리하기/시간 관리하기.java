import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfTask, min, sum;
    private final PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.deadline));

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
        numberOfTask = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        sum = 0;
        for (int i = 0; i < numberOfTask; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int duration = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            pq.offer(new Task(duration, deadline));
        }
    }

    private void solve() {
        while (!pq.isEmpty()) {
            Task poll = pq.poll();
            sum += poll.duration;
            if (sum > poll.deadline) {
                sb.append("-1");
                return;
            }
            min = Math.min(min, poll.deadline - sum);
        }
        sb.append(min);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static class Task implements Comparable<Task> {
        public int duration;
        public int deadline;

        public Task(int duration, int deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(Task task) {
            return Integer.compare(deadline, task.deadline);
        }
    }
}