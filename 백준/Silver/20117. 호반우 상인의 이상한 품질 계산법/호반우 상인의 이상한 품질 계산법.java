import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfCow, answer;
    private final List<Integer> qualities = new ArrayList<>();

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        numberOfCow = Integer.parseInt(br.readLine());
        answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfCow; i++) {
            qualities.add(Integer.parseInt(st.nextToken()));
        }
        qualities.sort(Comparator.naturalOrder());
    }

    private void solve() {
        for (int i = 0; i < numberOfCow / 2; i++) {
            answer += qualities.get(numberOfCow - 1 - i) * 2;
        }
        if (numberOfCow % 2 == 1) {
            answer += qualities.get(numberOfCow / 2);
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}