import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private final StringBuilder sb;
    private int a, b, c;
    private final TreeSet<OddPriorNumber> cocktail = new TreeSet<>();

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
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cocktail.add(new OddPriorNumber(a));
        cocktail.add(new OddPriorNumber(b));
        cocktail.add(new OddPriorNumber(c));
    }

    private void solve() {
        cocktail.add(new OddPriorNumber(a * b));
        cocktail.add(new OddPriorNumber(b * c));
        cocktail.add(new OddPriorNumber(c * a));
        cocktail.add(new OddPriorNumber(a * b * c));
        sb.append(cocktail.last().number);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static class OddPriorNumber implements Comparable<OddPriorNumber> {
        public int number;

        public OddPriorNumber(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(OddPriorNumber oddPriorNumber) {
            if (this.number % 2 == 1 && oddPriorNumber.number % 2 == 0) {
                return 1;
            } else if (this.number % 2 == 0 && oddPriorNumber.number % 2 == 1) {
                return -1;
            } else {
                return Integer.compare(this.number, oddPriorNumber.number);
            }
        }
    }
}