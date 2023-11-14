import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfLecture, answer;
    private final boolean[] isReserved = new boolean[10_001];
    private final List<Lecture> lectures = new ArrayList<>();

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
        numberOfLecture = Integer.parseInt(br.readLine());
        answer = 0;
        for (int i = 0; i < numberOfLecture; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int reward = Integer.parseInt(st.nextToken());
            int when = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(reward, when));
        }
        lectures.sort(Comparator.naturalOrder());
    }

    private void solve() {
        for (int i = 0; i < numberOfLecture; i++) {
            Lecture lecture = lectures.get(i);
            answer += lecture.place(isReserved);
        }
        sb.append(answer);
    }


    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static final class Lecture implements Comparable<Lecture> {
        public int reward;
        public int when;

        public Lecture(int reward, int when) {
            this.reward = reward;
            this.when = when;
        }

        public int place(boolean[] isReserved) {
            for (int i = when; i >= 1; i--) {
                if (isReserved[i]) {
                    continue;
                }
                isReserved[i] = true;
                return reward;
            }
            return 0;
        }

        @Override
        public int compareTo(Lecture lecture) {
            if (reward == lecture.reward) {
                return Integer.compare(when, lecture.when);
            }
            return Integer.compare(lecture.reward, reward);
        }
    }
}
