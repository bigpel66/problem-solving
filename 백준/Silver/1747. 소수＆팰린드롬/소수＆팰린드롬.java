import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private final StringBuffer sb;
    private static final int max = 2_000_000;
    private int number;
    private boolean[] isNotPrime = new boolean[max + 1];
    private Set<Integer> prime = new TreeSet<>();

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuffer();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        number = Integer.parseInt(br.readLine());
    }

    private void getPrimeNumber() {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 4; i <= max; i += 2) {
            isNotPrime[i] = true;
        }
        for (int i = 3; i <= Math.sqrt(max); i += 2) {
            for (int j = i * 3; j <= max; j += i * 2) {
                isNotPrime[j] = true;
            }
        }
        for (int i = number; i <= max; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            prime.add(i);
        }
    }

    private boolean isPalindrome(String cur) {
        for (int i = 0; i < cur.length() / 2; i++) {
            if (cur.charAt(i) != cur.charAt(cur.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private void solve() {
        getPrimeNumber();
        for (int cur : prime) {
            if (isPalindrome(String.valueOf(cur))) {
                sb.append(cur);
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}