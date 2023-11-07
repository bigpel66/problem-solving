import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfTree, numberOfOdd, sum;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        numberOfTree = Integer.parseInt(br.readLine());
        numberOfOdd = 0;
        sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfTree; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value % 2 == 1) {
                numberOfOdd++;
            }
            sum += value;
        }
    }

    private void solve() {
        if (sum % 3 == 0 && numberOfOdd <= sum / 3) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}