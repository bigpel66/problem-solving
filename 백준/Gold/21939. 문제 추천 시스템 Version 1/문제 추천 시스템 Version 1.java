import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfInitialProblem, numberOfCommand;
    TreeSet<Problem> set = new TreeSet<>();
    Map<Integer, Integer> map = new HashMap<>();

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws IOException {
        numberOfInitialProblem = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfInitialProblem; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            addEntry(st);
        }
        numberOfCommand = Integer.parseInt(br.readLine());
    }

    void addEntry(StringTokenizer st) {
        int number = Integer.parseInt(st.nextToken());
        int level = Integer.parseInt(st.nextToken());
        set.add(new Problem(number, level));
        map.put(number, level);
    }

    void recommendEntry(StringTokenizer st) {
        boolean isFront = st.nextToken().equals("-1");
        Problem p;
        if (isFront) {
            p = set.first();
        } else {
            p = set.last();
        }
        sb.append(p.number.toString() + '\n');
    }

    void removeEntry(StringTokenizer st) {
        int number = Integer.parseInt(st.nextToken());
        int level = map.get(number);
        set.remove(new Problem(number, level));
        map.remove(number);
    }

    void handleCommand(String command, StringTokenizer st) {
        if (command.equals("add")) {
            addEntry(st);
        } else if (command.equals("recommend")) {
            recommendEntry(st);
        } else if (command.equals("solved")) {
            removeEntry(st);
        }
    }

    void solve() throws Exception {
        for (int i = 0; i < numberOfCommand; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            handleCommand(st.nextToken(), st);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public class Problem implements Comparable<Problem> {
        public Integer number;
        public Integer level;

        public Problem(String number) {
            this.number = Integer.parseInt(number);
            this.level = 0;
        }

        public Problem(String number, String level) {
            this.number = Integer.parseInt(number);
            this.level = Integer.parseInt(level);
        }

        public Problem(Integer number, Integer level) {
            this.number = number;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) {
                return this.number - o.number;
            }
            return this.level - o.level;
        }
    }
}