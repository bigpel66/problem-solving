import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfSequence;
    private int[] sequence, temp;

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
        sequence = new int[numberOfSequence + 1];
        temp = new int[numberOfSequence + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = numberOfSequence; i >= 1; i--) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    private int bsearch(int[] array, int left, int right, int value) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private void solve() {
        int tempIndex = 0;
        for (int i = 1; i <= numberOfSequence; i++) {
            int value = sequence[i];
            if (temp[tempIndex] < value) {
                temp[++tempIndex] = value;
            } else {
                int place = bsearch(temp, 1, tempIndex, value);
                temp[place] = value;
            }
        }
        sb.append(Arrays.stream(temp).filter(e -> e != 0).count());
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
