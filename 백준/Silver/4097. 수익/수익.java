import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int numberOfSequence;
    private int[] money;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            while (getInput(br)) {
                solve();
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private boolean getInput(BufferedReader br) throws Exception {
        numberOfSequence = Integer.parseInt(br.readLine());
        if (numberOfSequence == 0) {
            return false;
        }
        money = new int[numberOfSequence + 1];
        for (int i = 1; i <= numberOfSequence; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        return true;
    }

    private void solve() {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= numberOfSequence; i++) {
            sum += money[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        sb.append(max).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
