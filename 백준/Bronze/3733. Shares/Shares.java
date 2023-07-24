import java.io.*;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    Integer numberOfPerson, shares;

    public Main() throws Exception {
        while (getInput()) {
            solve();
        }
        bw.write(sb.toString());
        bw.flush();
    }

    boolean getInput() throws Exception {
        String line = br.readLine();
        if (line == null) {
            return false;
        }
        StringTokenizer st = new StringTokenizer(line);
        numberOfPerson = Integer.parseInt(st.nextToken());
        shares = Integer.parseInt(st.nextToken());
        return true;
    }

    void solve() throws Exception {
        Integer value = (shares / (numberOfPerson + 1));
        sb.append(value.toString() + '\n');
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}