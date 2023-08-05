import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int numberOfParticipant;
    Map<String, Integer> map = new HashMap<>();

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws Exception {
        numberOfParticipant = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfParticipant; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
    }

    void solve() throws Exception {
        for (int i = 0; i < numberOfParticipant - 1; i++) {
            String name = br.readLine();
            if (map.get(name) == 1) {
                map.remove(name);
            } else {
                map.put(name, map.get(name) - 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.write(entry.getKey() + '\n');
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}