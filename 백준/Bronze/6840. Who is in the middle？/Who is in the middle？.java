import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] arr = new int[3];

    public Main() throws Exception {
        getInput();
        solve();
    }

    void getInput() throws Exception {
        arr[0] = Integer.parseInt(br.readLine());
        arr[1] = Integer.parseInt(br.readLine());
        arr[2] = Integer.parseInt(br.readLine());
    }

    void solve() throws Exception {
        if ((arr[0] > arr[1] && arr[0] < arr[2]) || (arr[0] > arr[2] && arr[0] < arr[1])) {
            bw.write(String.valueOf(arr[0]));
        } else if ((arr[1] > arr[2] && arr[1] < arr[0]) || (arr[1] > arr[0] && arr[1] < arr[2])) {
            bw.write(String.valueOf(arr[1]));
        } else if ((arr[2] > arr[0] && arr[2] < arr[1]) || (arr[2] > arr[1] && arr[2] < arr[0])) {
            bw.write(String.valueOf(arr[2]));
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}