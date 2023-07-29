import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    Long size;
    Map<String, Integer> map = new TreeMap<>();

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws IOException {
        size = 0L;
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
            size++;
        }
    }

    void solve() throws IOException {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double percent = (double) entry.getValue() * 100 / size;
            sb.append(entry.getKey() + ' ');
            sb.append(String.format("%.4f\n", percent));
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}