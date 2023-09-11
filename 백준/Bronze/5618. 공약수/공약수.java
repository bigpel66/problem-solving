import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private final StringBuffer sb;
    private int count;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuffer();
            getInput(br);
            solve(br);
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        count = Integer.parseInt(br.readLine());
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private void solve(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count - 1; i++) {
            int comp = Integer.parseInt(st.nextToken());
            value = gcd(value, comp);
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                set.add(i);
                if (value != i * i) {
                    set.add(value / i);
                }
            }
        }
        for (int n : set) {
            sb.append(n).append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}