import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfBalloon, answer;
    private final List<Integer> heights = new ArrayList<>();
    private final Map<Integer, Integer> ahead = new HashMap<>();

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
        numberOfBalloon = Integer.parseInt(br.readLine());
        answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfBalloon; i++) {
            heights.add(Integer.parseInt(st.nextToken()));
        }
    }

    private void solve() {
        for (int height : heights) {
            boolean isContinuous = ahead.containsKey(height + 1);
            if (!isContinuous) {
                ahead.put(height, ahead.getOrDefault(height, 0) + 1);
                continue;
            }
            int count = ahead.get(height + 1) - 1;
            if (count == 0) {
                ahead.remove(height + 1);
            } else {
                ahead.put(height + 1, count);
            }
            ahead.put(height, ahead.getOrDefault(height, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : ahead.entrySet()) {
            answer += entry.getValue();
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}