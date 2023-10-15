import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfTown;
    private BigInteger totalResidence = new BigInteger("0");
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
            int position = Integer.parseInt(st.nextToken());
            int residence = Integer.parseInt(st.nextToken());
            totalResidence = totalResidence.add(new BigInteger(String.valueOf(residence)));
            towns.add(new Town(position, residence));
        }
        towns.sort(Comparator.naturalOrder());
    }

    private void solve() {
        BigInteger current = new BigInteger("0");
        BigInteger limit = totalResidence.subtract(new BigInteger("1")).divide(new BigInteger("2"));
        for (int i = 0; i < numberOfTown; i++) {
            current = current.add(new BigInteger(String.valueOf(towns.get(i).residence)));
            if (current.compareTo(limit) > 0) {
                sb.append(towns.get(i).position);
                return;
            }
        }
        throw new AssertionError();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static final class Town implements Comparable<Town> {
        public int position;
        public int residence;

        public Town(int position, int residence) {
            this.position = position;
            this.residence = residence;
        }

        @Override
        public int compareTo(Town town) {
            return Integer.compare(position, town.position);
        }
    }
}