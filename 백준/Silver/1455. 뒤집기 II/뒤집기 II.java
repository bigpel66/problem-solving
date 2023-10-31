import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int answer;
    private int rowSize, colSize;
    private byte[][] grid;

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
        answer = 0;
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        grid = new byte[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            String line = br.readLine();
            for (int j = 0; j < colSize; j++) {
                grid[i][j] = (byte) (line.charAt(j) - '0');
            }
        }
    }

    private void flip(int row, int col) {
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                }
            }
        }
    }

    private void solve() {
        for (int i = rowSize - 1; i >= 0; i--) {
            for (int j = colSize - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    flip(i, j);
                    answer++;
                }
            }
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}