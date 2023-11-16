import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfCarrot, numberOfDay;
    private long answer;
    private final List<Carrot> carrots = new ArrayList<>();

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
        numberOfCarrot = Integer.parseInt(st.nextToken());
        numberOfDay = Integer.parseInt(st.nextToken());
        answer = 0L;
        for (int i = 0; i < numberOfCarrot; i++) {
            st = new StringTokenizer(br.readLine());
            int init = Integer.parseInt(st.nextToken());
            int increment = Integer.parseInt(st.nextToken());
            carrots.add(new Carrot(init, increment));
        }
        carrots.sort(Comparator.naturalOrder());
    }

    private void solve() {
        for (int i = 0; i < numberOfCarrot; i++) {
            Carrot carrot = carrots.get(i);
            answer += (long) carrot.init + (long) carrot.increment * (numberOfDay - numberOfCarrot + i);
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static final class Carrot implements Comparable<Carrot> {
        public int init;
        public int increment;

        public Carrot(int init, int increment) {
            this.init = init;
            this.increment = increment;
        }

        @Override
        public int compareTo(Carrot carrot) {
            if (increment == carrot.increment) {
                return Integer.compare(init, carrot.init);
            }
            return Integer.compare(increment, carrot.increment);
        }
    }
}
