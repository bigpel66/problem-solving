import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private final StringBuilder sb;
    private int numberOfOctopus;

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
        numberOfOctopus = Integer.parseInt(br.readLine());
    }


    private void solve() {
        StringBuilder temp = new StringBuilder();
        if (numberOfOctopus % 2 == 1) {
            temp.append(" ").append("3");
            numberOfOctopus--;
        }
        for (int i = 0; i < numberOfOctopus; i++) {
            temp.append(" ");
            if (i % 2 == 0) {
                temp.append("2");
            } else {
                temp.append("1");
            }
        }
        sb.append(temp.reverse());
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}