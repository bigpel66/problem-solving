import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int numberOfTest;

    public Main() throws Exception {
        getInput();
        while (numberOfTest-- != 0) {
            solve();
        }
    }

    void getInput() throws Exception {
        numberOfTest = Integer.parseInt(br.readLine());
    }

    void solve() throws Exception {
        Set<Integer> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        int numberOfMemory = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfMemory; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        numberOfMemory = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfMemory; i++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}