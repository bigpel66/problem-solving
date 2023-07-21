import java.io.*;

public class Main {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public Main() throws Exception {
        solve();
    }

    void solve() throws IOException {
        bw.write("#  # #### #### #  #\n" +
                "#### #  # #  # # #\n" +
                "#### #  # #  # # #\n" +
                "#  # #### #### #  #");
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}