import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int numberOfBook, max;
    List<String> best = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws Exception {
        numberOfBook = Integer.parseInt(br.readLine());
        max = 0;
        for (int i = 0; i < numberOfBook; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
    }

    void solve() throws Exception {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                best.add(entry.getKey());
            }
        }
        best.sort(Comparator.naturalOrder());
        bw.write(best.get(0));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}