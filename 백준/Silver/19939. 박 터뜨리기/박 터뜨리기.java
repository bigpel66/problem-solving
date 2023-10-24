import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfBall, numberOfBasket, limit;

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
        numberOfBall = Integer.parseInt(st.nextToken());
        numberOfBasket = Integer.parseInt(st.nextToken());
        limit = (numberOfBasket * (numberOfBasket + 1)) / 2;
    }

    private void solve() {
        if (numberOfBall < limit) {
            sb.append(-1);
        } else if ((numberOfBall - limit) % numberOfBasket == 0) {
            sb.append(numberOfBasket - 1);
        } else {
            sb.append(numberOfBasket);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}