import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int lines;

    public Main() throws Exception {
        getInput();
        bw.write("비와이");
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        lines = Integer.parseInt(st.nextToken());
        for (int i = 0; i < lines; i++) {
            br.readLine();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}