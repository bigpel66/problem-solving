import java.io.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public Main() throws Exception {
        solve();
    }

    void solve() throws IOException {
        bw.write("NFC West       W   L  T\n" +
                "-----------------------\n" +
                "Seattle        13  3  0\n" +
                "San Francisco  12  4  0\n" +
                "Arizona        10  6  0\n" +
                "St. Louis      7   9  0\n" +
                "\n" +
                "NFC North      W   L  T\n" +
                "-----------------------\n" +
                "Green Bay      8   7  1\n" +
                "Chicago        8   8  0\n" +
                "Detroit        7   9  0\n" +
                "Minnesota      5  10  1");
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}