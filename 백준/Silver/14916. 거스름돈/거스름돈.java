import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final StringBuilder sb;
    private int change, numberOfCoin;

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
        change = Integer.parseInt(br.readLine());
    }

    private void solve() {
        while (change > 0) {
            if (change % 5 == 0) {
                numberOfCoin += change / 5;
                break;
            } else {
                change -= 2;
                numberOfCoin++;
            }
        }
        if (change < 0) {
            sb.append(-1);
        } else {
            sb.append(numberOfCoin);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}