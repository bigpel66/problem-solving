import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfTown;
    private long totalPeople;
    private List<Town> towns = new ArrayList<>();

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
        numberOfTown = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfTown; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            totalPeople += people;
            towns.add(new Town(pos, people));
        }
        towns.sort(Comparator.naturalOrder());
    }

    private void solve() {
        long current = 0;
        for (int i = 0; i < numberOfTown; i++) {
            current += towns.get(i).people;
            if (current > (totalPeople - 1) / 2) {
                sb.append(towns.get(i).pos);
                return;
            }
        }
        throw new AssertionError();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static final class Town implements Comparable<Town> {
        public int pos;
        public int people;

        public Town(int pos, int people) {
            this.pos = pos;
            this.people = people;
        }

        @Override
        public int compareTo(Town town) {
            return Integer.compare(pos, town.pos);
        }
    }
}