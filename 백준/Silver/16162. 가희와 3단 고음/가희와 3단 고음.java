import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfNote, value, increment, level;
    private int[] notes;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNote = Integer.parseInt(st.nextToken());
        value = Integer.parseInt(st.nextToken());
        increment = Integer.parseInt(st.nextToken());
        level = 0;
        notes = new int[numberOfNote];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfNote; i++) {
            notes[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        for (int i = 0; i < numberOfNote; i++) {
            if (value == notes[i]) {
                level++;
                value += increment;
            }
        }
        sb.append(level);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}