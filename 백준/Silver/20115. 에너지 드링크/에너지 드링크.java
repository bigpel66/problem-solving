import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private int numberOfDrink;
    private int[] amount;
    private double answer;

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
        numberOfDrink = Integer.parseInt(br.readLine());
        amount = new int[numberOfDrink];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfDrink; i++) {
            amount[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(amount);
        answer = amount[amount.length - 1];
        numberOfDrink--;
    }

    private void solve() {
        for (int i = 0; i < numberOfDrink; i++) {
            answer += ((double) amount[i] / 2);
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}