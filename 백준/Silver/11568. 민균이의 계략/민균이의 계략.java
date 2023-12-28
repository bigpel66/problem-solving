import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;

    private int numberOfSequence;
    private int[] arr, temp;

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
        arr = new int[numberOfSequence + 1];
        temp = new int[numberOfSequence + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfSequence; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private int bsearch(int begin, int end, int value) {
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (temp[mid] < value) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private void solve() {
        int tempIndex = 0;
        for (int i = 1; i <= numberOfSequence; i++) {
            if (temp[tempIndex] < arr[i]) {
                temp[++tempIndex] = arr[i];
            } else {
                int index = bsearch(1, tempIndex, arr[i]);
                temp[index] = arr[i];
            }
        }
        sb.append(Arrays.stream(temp).filter(e -> e != 0).count());
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
