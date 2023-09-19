import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private static final int MAX = 100_001;
    private int combination, modular, answer;
    private boolean[] isVisited = new boolean[10];
    private boolean[] isNotPrime = new boolean[MAX + 1];
    private boolean[] candidate1 = new boolean[MAX + 1];
    private boolean[] candidate2 = new boolean[MAX + 1];
    private Set<Integer> prime = new HashSet<>();

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        combination = Integer.parseInt(st.nextToken());
        modular = Integer.parseInt(st.nextToken());
    }

    private void getPrimeDecision() {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 4; i <= MAX; i += 2) {
            isNotPrime[i] = true;
        }
        for (int i = 3; i <= Math.sqrt(MAX); i += 2) {
            for (int j = i * 3; j <= MAX; j += i * 2) {
                isNotPrime[j] = true;
            }
        }
        for (int i = 2; i <= MAX; i++) {
            if (!isNotPrime[i]) {
                prime.add(i);
            }
        }
    }

    private void getCandidate1() {
        for (int i : prime) {
            for (int j : prime) {
                if (i == j) {
                    continue;
                }
                if (i + j <= MAX) {
                    candidate1[i + j] = true;
                }
            }
        }
    }

    private void getCandidate2() {
        for (int i : prime) {
            for (int j : prime) {
                long mul = (long) i * (long) j;
                if (mul <= MAX) {
                    candidate2[(int) mul] = true;
                }
            }
        }
    }

    private int transform(int value) {
        while (value % modular == 0) {
            value /= modular;
        }
        return value;
    }

    private void searchBothSatisfied(int cur, int count) {
        if (count == combination) {
            if (candidate1[cur] && candidate2[transform(cur)]) {
                answer++;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (isVisited[i] || (i == 0 && count == 0)) {
                continue;
            }
            isVisited[i] = true;
            searchBothSatisfied(cur * 10 + i, count + 1);
            isVisited[i] = false;
        }
    }

    private void solve() {
        getPrimeDecision();
        getCandidate1();
        getCandidate2();
        searchBothSatisfied(0, 0);
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}