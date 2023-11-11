import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private String stringA, stringB;

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
        stringA = br.readLine();
        stringB = br.readLine();
    }

    private boolean isTwoInputDifferent() {
        int[] alphabets = new int[26];
        for (int i = 0; i < stringA.length(); i++) {
            ++alphabets[stringA.charAt(i) - 'A'];
            --alphabets[stringB.charAt(i) - 'A'];
        }
        for (int i = 0; i < 26; i++) {
            if (alphabets[i] != 0) {
                return true;
            }
        }
        return false;
    }

    private int findMoveCount() {
        int count = 0;
        for (int offset = stringB.length() - 1, i = stringA.length() - 1; i >= 0; i--) {
            if (stringA.charAt(i) == stringB.charAt(offset)) {
                offset--;
            } else {
                count++;
            }
        }
        return count;
    }

    private void solve() {
        if (isTwoInputDifferent()) {
            sb.append(-1);
        } else {
            sb.append(findMoveCount());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
