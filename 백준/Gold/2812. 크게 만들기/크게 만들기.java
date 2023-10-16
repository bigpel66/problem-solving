import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfDigit, numberOfRemove;
    private String number;
    private Deque<Character> stack = new LinkedList<>();

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
        numberOfDigit = Integer.parseInt(st.nextToken());
        numberOfRemove = Integer.parseInt(st.nextToken());
        number = br.readLine();
    }

    private void solve() {
        int limit = numberOfDigit - numberOfRemove;
        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && numberOfRemove > 0 && stack.peekLast() < number.charAt(i)) {
                stack.pollLast();
                numberOfRemove--;
            }
            stack.offerLast(number.charAt(i));
        }
        for (int i = 0; i < limit; i++) {
            sb.append(stack.pollFirst());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}