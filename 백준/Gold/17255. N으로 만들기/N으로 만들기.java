import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String target;
    Set<String> paths = new HashSet<>();

    public Main() throws Exception {
        getInput();
        for (int i = 0; i < target.length(); i++) {
            solve(i, i, "" + target.charAt(i), "" + target.charAt(i));
        }
        bw.write(String.valueOf(paths.size()));
        bw.flush();
    }

    void getInput() throws Exception {
        target = br.readLine();
    }

    void solve(int left, int right, String number, String path) {
        if (left == 0 && right == target.length() - 1) {
            paths.add(path);
            return;
        }
        if (left - 1 >= 0) {
            solve(left - 1, right, target.charAt(left - 1) + number, path + target.charAt(left - 1) + number);
        }
        if (right + 1 < target.length()) {
            solve(left, right + 1, number + target.charAt(right + 1), path + number + target.charAt(right + 1));
        }

    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}