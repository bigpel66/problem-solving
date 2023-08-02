import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int numberOfProblem, numberOfCommand;
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();
    TreeSet<Problem> problems = new TreeSet<>();
    Map<Integer, TreeSet<Problem>> algorithms = new HashMap<>();
    Map<Integer, Integer> indexToLevel = new HashMap<>();
    Map<Integer, Integer> indexToAlgorithm = new HashMap<>();

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws Exception {
        numberOfProblem = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfProblem; i++) {
            st = new StringTokenizer(br.readLine());
            add(st);
        }
        numberOfCommand = Integer.parseInt(br.readLine());
    }

    void add(StringTokenizer st) {
        int index = Integer.parseInt(st.nextToken());
        int level = Integer.parseInt(st.nextToken());
        int algorithm = Integer.parseInt(st.nextToken());
        problems.add(new Problem(index, level, algorithm));
        TreeSet<Problem> temp = algorithms.getOrDefault(algorithm, new TreeSet<>());
        temp.add(new Problem(index, level, algorithm));
        algorithms.put(algorithm, temp);
        indexToLevel.put(index, level);
        indexToAlgorithm.put(index, algorithm);
    }

    void remove(StringTokenizer st) {
        int index = Integer.parseInt(st.nextToken());
        int level = indexToLevel.get(index);
        int algorithm = indexToAlgorithm.get(index);
        problems.remove(new Problem(index, level, algorithm));
        algorithms.get(algorithm).remove(new Problem(index, level, algorithm));
        indexToLevel.remove(index);
        indexToAlgorithm.remove(index);
    }

    void recommendOneOrTwo(StringTokenizer st, TreeSet<Problem> ts) {
        boolean isHard = st.nextToken().equals("1");
        if (isHard) {
            sb.append(ts.last().index);
        } else {
            sb.append(ts.first().index);
        }
        sb.append('\n');
    }

    void recommendThree(StringTokenizer st) {
        boolean isHard = st.nextToken().equals("1");
        int offset = Integer.parseInt(st.nextToken());
        if (isHard) {
            Problem ceiling = problems.ceiling(new Problem(offset));
            if (ceiling == null) {
                sb.append(-1);
            } else {
                sb.append(ceiling.index);
            }
        } else {
            Problem floor = problems.floor(new Problem(offset));
            if (floor == null) {
                sb.append(-1);
            } else {
                sb.append(floor.index);
            }
        }
        sb.append('\n');
    }

    void handleCommand(StringTokenizer st) {
        String command = st.nextToken();
        if (command.equals("add")) {
            add(st);
        } else if (command.equals("solved")) {
            remove(st);
        } else if (command.equals("recommend")) {
            int algorithm = Integer.parseInt(st.nextToken());
            TreeSet<Problem> temp = algorithms.get(algorithm);
            recommendOneOrTwo(st, temp);
        } else if (command.equals("recommend2")) {
            recommendOneOrTwo(st, problems);
        } else if (command.equals("recommend3")) {
            recommendThree(st);
        }
    }

    void solve() throws Exception {
        for (int i = 0; i < numberOfCommand; i++) {
            st = new StringTokenizer(br.readLine());
            handleCommand(st);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    static public class Problem implements Comparable<Problem> {
        int index;
        int level;
        int algorithm;

        public Problem(int level) {
            this.index = 0;
            this.level = level;
            this.algorithm = 0;
        }

        public Problem(int index, int level, int algorithm) {
            this.index = index;
            this.level = level;
            this.algorithm = algorithm;
        }

        @Override
        public int compareTo(Problem problem) {
            if (this.level == problem.level) {
                return this.index - problem.index;
            }
            return this.level - problem.level;
        }
    }
}