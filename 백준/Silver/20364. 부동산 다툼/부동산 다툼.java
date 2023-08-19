import java.io.*;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfNode, numberOfQuery;
    boolean[] isVisited;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        numberOfQuery = Integer.parseInt(st.nextToken());
        isVisited = new boolean[numberOfNode + 1];
    }

    void solve() throws IOException {
        for (int i = 0; i < numberOfQuery; i++) {
            int target = Integer.parseInt(br.readLine());
            int answer = 0;
            int temp = target;
            while (temp >= 1) {
                if (isVisited[temp]) {
                    answer = temp;
                }
                temp >>= 1;
            }
            isVisited[target] = true;
            sb.append(answer).append('\n');
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}