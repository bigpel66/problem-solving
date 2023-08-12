import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    Map<Integer, Integer> map = new HashMap<>();
    int numberOfNode;
    int numberOfQuery;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfNode - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.put(from, map.getOrDefault(from, 0) + 1);
            map.put(to, map.getOrDefault(to, 0) + 1);
        }
        numberOfQuery = Integer.parseInt(br.readLine());
    }

    boolean isForNode(int command) {
        return command == 1;
    }

    void solve() throws Exception {
        for (int i = 0; i < numberOfQuery; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            if (isForNode(command)) {
                if (map.get(target) < 2) {
                    sb.append("no\n");
                } else {
                    sb.append("yes\n");
                }
            } else {
                sb.append("yes\n");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}