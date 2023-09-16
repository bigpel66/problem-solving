import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private String numberA, numberB;
    private int maxRadixA, maxRadixB;
    private Set<String> expression = new HashSet<>();

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
        maxRadixA = maxRadixB = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberA = st.nextToken();
        for (int i = 0; i < numberA.length(); i++) {
            maxRadixA = (char) Math.max(maxRadixA, numberA.charAt(i));
        }
        numberB = st.nextToken();
        for (int i = 0; i < numberB.length(); i++) {
            maxRadixB = (char) Math.max(maxRadixB, numberB.charAt(i));
        }
    }

    private int radixStringToNumber(int formation) {
        if (Character.isDigit(formation)) {
            formation = (formation - '0' + 1);
        } else {
            formation = (formation - 'a' + 10 + 1);
        }
        return formation;
    }

    private void solve() {
        maxRadixA = radixStringToNumber(maxRadixA);
        maxRadixB = radixStringToNumber(maxRadixB);
        for (int i = maxRadixA; i <= 36; i++) {
            for (int j = maxRadixB; j <= 36; j++) {
                if (i == j) {
                    continue;
                }
                try {
                    long parsedA = Long.parseLong(numberA, i);
                    long parsedB = Long.parseLong(numberB, j);
                    if (parsedA == parsedB) {
                        expression.add(parsedA + " " + i + " " + j);
                    }
                } catch (NumberFormatException ignored) {
                }
            }
        }
        if (expression.isEmpty()) {
            sb.append("Impossible");
        } else if (expression.size() == 1) {
            sb.append(expression.stream().findAny().get());
        } else {
            sb.append("Multiple");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}