import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public final class Main {
    private static final int MAX = 1_000_000;
    private static final int UNIT = 100;
    private final StringBuilder sb;
    private int goalUsers, numberOfCity;
    private City[] cities;

    private int[] dp;

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
        goalUsers = Integer.parseInt(st.nextToken());
        numberOfCity = Integer.parseInt(st.nextToken());
        cities = new City[numberOfCity + 1];
        dp = new int[goalUsers + UNIT + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i <= numberOfCity; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int gather = Integer.parseInt(st.nextToken());
            cities[i] = new City(cost, gather);
        }
    }

    private void updateKnapsack(City city) {
        for (int i = city.gather; i <= goalUsers + UNIT; i++) {
            dp[i] = Math.min(dp[i], dp[i - city.gather] + city.cost);
        }
    }

    private void solve() {
        for (int i = 1; i <= numberOfCity; i++) {
            updateKnapsack(cities[i]);
        }
        int min = IntStream.rangeClosed(goalUsers, goalUsers + UNIT).map(e -> dp[e]).min().getAsInt();
        sb.append(min);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static final class City {
        public int cost;
        public int gather;

        public City(int cost, int gather) {
            this.cost = cost;
            this.gather = gather;
        }
    }
}
