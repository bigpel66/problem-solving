import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.Math;

public final class Main {
    private final StringBuilder sb;
    private int length, whiteToBlack, blackToWhite;
    private String source, target;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            int numberOfTest = Integer.parseInt(br.readLine());
            while (numberOfTest-- > 0) {
                getInput(br);
                solve(); 
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        length = Integer.parseInt(br.readLine());
        source = br.readLine();
        target = br.readLine();
        whiteToBlack = 0;
        blackToWhite = 0;
    }

    private void solve() {
        for (int i = 0 ; i < length ; i++) {
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }
            if (source.charAt(i) == 'W') {
                whiteToBlack++;
            } else {
                blackToWhite++;
            }
        }
        sb.append(Math.max(whiteToBlack, blackToWhite)).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}