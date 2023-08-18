import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfTest, numberOfNode;

    public Main() throws Exception {
        numberOfTest = Integer.parseInt(br.readLine());
        while (numberOfTest-- > 0) {
            getInput();
            solve();
        }
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfNode = Integer.parseInt(st.nextToken());
        int numberOfAirplane = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numberOfAirplane; i++) {
            br.readLine();
        }
    }

    void solve() {
        sb.append(numberOfNode - 1).append('\n');
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
    
}