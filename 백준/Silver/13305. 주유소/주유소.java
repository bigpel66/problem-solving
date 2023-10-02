import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private int numberOfCity;
    private int[] distance;
    private int[] pricePerLiter;
    private long sum, cache;

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
        numberOfCity = Integer.parseInt(br.readLine());
        distance = new int[numberOfCity - 1];
        pricePerLiter = new int[numberOfCity];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pricePerLiter.length; i++) {
            pricePerLiter[i] = Integer.parseInt(st.nextToken());
        }
        sum = 0L;
        cache = Long.MAX_VALUE;
    }

    private void solve() {
        for (int i = 0; i < distance.length; i++) {
            cache = Math.min(cache, pricePerLiter[i]);
            sum += cache * distance[i];
        }
        sb.append(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}