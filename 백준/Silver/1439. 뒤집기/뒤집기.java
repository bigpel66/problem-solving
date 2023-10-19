import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int numberOfZero, numberOfOne;
    private String string;

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
        string = br.readLine();
    }


    private void solve() {
        char prev = string.charAt(0);
        if (prev == '0') {
            numberOfZero++;
        } else {
            numberOfOne++;
        }
        for (int i = 1; i < string.length(); i++) {
            char curr = string.charAt(i);
            if (prev != curr) {
                if (curr == '0') {
                    numberOfZero++;
                } else {
                    numberOfOne++;
                }
            }
            prev = curr;
        }
        sb.append(Math.min(numberOfZero, numberOfOne));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}