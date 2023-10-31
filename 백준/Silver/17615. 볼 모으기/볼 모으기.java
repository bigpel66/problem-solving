import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class Main {
    private final StringBuilder sb;
    private int red, blue;
    private String sequence;

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
        br.readLine();
        sequence = br.readLine();
        red = 0;
        blue = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'R') {
                red++;
            } else if (sequence.charAt(i) == 'B') {
                blue++;
            }
        }
    }

    private int countFromLeft(char ch) {
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) != ch) {
                break;
            }
            count++;
        }
        return count;
    }

    private int countFromRight(char ch) {
        int count = 0;
        for (int i = sequence.length() - 1; i >= 0; i--) {
            if (sequence.charAt(i) != ch) {
                break;
            }
            count++;
        }
        return count;
    }

    private <E extends Comparable<? super E>> Optional<E> min(List<E> list) {
        return list.stream().min(Comparator.naturalOrder());
    }

    private void solve() {
        int lr = red - countFromLeft('R');
        int lb = blue - countFromLeft('B');
        int rr = red - countFromRight('R');
        int rb = blue - countFromRight('B');
        sb.append(min(Arrays.asList(lr, lb, rr, rb)).get());
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}