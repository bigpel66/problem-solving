import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfCake, limitCut, answer;
    private final List<Integer> cleanCakes = new ArrayList<>();
    private final List<Integer> remainCakes = new ArrayList<>();

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfCake = Integer.parseInt(st.nextToken());
        limitCut = Integer.parseInt(st.nextToken());
        answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfCake; i++) {
            int cake = Integer.parseInt(st.nextToken());
            if (cake % 10 == 0) {
                cleanCakes.add(cake);
            } else {
                remainCakes.add(cake);
            }
        }
        cleanCakes.sort(Comparator.naturalOrder());
        remainCakes.sort(Comparator.naturalOrder());
    }

    private void solve() {
        for (int cake : cleanCakes) {
            if (limitCut <= 0) break;
            int piece = cake / 10;
            int cut = piece - 1;
            if (limitCut < cut) {
                cut = limitCut;
                piece = cut;
                if (cake - (piece * 10) == 10) {
                    piece++;
                }
            }
            limitCut -= cut;
            answer += piece;
        }
        for (int cake : remainCakes) {
            if (limitCut <= 0) break;
            int piece = cake / 10;
            int cut = piece;
            if (limitCut < cut) {
                cut = limitCut;
                piece = cut;
            }
            limitCut -= cut;
            answer += piece;
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}