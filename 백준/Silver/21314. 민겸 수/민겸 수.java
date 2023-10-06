import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final String FIVE = "5";
    private static final String ONE = "1";
    private static final String ZERO = "0";
    private final StringBuilder sb;
    private char[] numberForMax;
    private char[] numberForMin;

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
        String number = br.readLine();
        numberForMax = number.toCharArray();
        numberForMin = number.toCharArray();
    }

    private String repeat(String value, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(value);
        }
        return builder.toString();
    }

    private String getMax() {
        int mCount = 0;
        StringBuilder builder = new StringBuilder();
        for (char forMax : numberForMax) {
            if (forMax == 'M') {
                mCount++;
                continue;
            }
            if (forMax == 'K') {
                builder.append(FIVE).append(repeat(ZERO, mCount));
                mCount = 0;
            }
        }
        if (mCount != 0) {
            builder.append(repeat(ONE, mCount));
        }
        return builder.toString();
    }

    private String getMin() {
        int mCount = 0;
        StringBuilder builder = new StringBuilder();
        for (char forMin : numberForMin) {
            if (forMin == 'M') {
                mCount++;
                continue;
            }
            if (mCount > 0) {
                builder.append(ONE);
                mCount--;
            }
            builder.append(repeat(ZERO, mCount)).append(FIVE);
            mCount = 0;
        }
        if (mCount != 0) {
            builder.append(ONE).append(repeat(ZERO, mCount - 1));
        }
        return builder.toString();
    }

    private void solve() {
        sb.append(getMax());
        sb.append("\n");
        sb.append(getMin());
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}