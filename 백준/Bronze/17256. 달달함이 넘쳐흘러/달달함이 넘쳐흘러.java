import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private Coord a, c;

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
        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int az = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int cz = Integer.parseInt(st.nextToken());
        a = new Coord(ax, ay, az);
        c = new Coord(cx, cy, cz);
    }

    private void solve() throws Exception {
        sb.append(a.solve(c));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    private static final class Coord {
        public int x;
        public int y;
        public int z;

        public Coord(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Coord solve(Coord coord) {
            return new Coord(coord.x - z, coord.y / y, coord.z - x);
        }

        @Override
        public String toString() {
            return x + " " + y + " " + z;
        }
    }
}
