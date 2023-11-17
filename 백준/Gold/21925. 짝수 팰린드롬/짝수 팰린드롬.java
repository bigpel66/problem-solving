import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfSequence, answer;
    private final List<Integer> numbers = new ArrayList<>();
    private final List<Integer> stack = new ArrayList<>();

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
        numberOfSequence = Integer.parseInt(br.readLine());
        answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfSequence; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
    }

    private boolean isSymmetricExpectedFrom(int index) {
        List<Integer> temp = new ArrayList<>(stack);
        while (!temp.isEmpty()) {
            if (index >= numberOfSequence || !Objects.equals(temp.get(temp.size() - 1), numbers.get(index))) {
                return false;
            }
            temp.remove(temp.size() - 1);
            index++;
        }
        return true;
    }

    private void loop() {
        for (int i = 0; i < numberOfSequence; i++) {
            int number = numbers.get(i);
            if (stack.isEmpty()) {
                stack.add(number);
                continue;
            }
            if (isSymmetricExpectedFrom(i)) {
                i += stack.size() - 1;
                answer++;
                stack.clear();
            } else {
                stack.add(number);
            }
        }
    }

    private void solve() {
        loop();
        if (stack.isEmpty()) {
            sb.append(answer);
        } else {
            sb.append(-1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
