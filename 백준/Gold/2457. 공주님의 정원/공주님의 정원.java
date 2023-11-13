import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfFlower, answer;
    private static final int INCLUSIVE_BEGIN = 301;
    private static final int EXCLUSIVE_END = 1201;
    private final List<Flower> flowers = new ArrayList<>();

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
        numberOfFlower = Integer.parseInt(br.readLine());
        answer = 0;
        for (int i = 0; i < numberOfFlower; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            begin = begin * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            end = end * 100 + Integer.parseInt(st.nextToken());
            flowers.add(new Flower(begin, end));
        }
        flowers.sort(Comparator.naturalOrder());
    }

    private int findMaxEndByComparingBeginBeforeCur(int cur) {
        int offset = cur;
        for (Flower flower : flowers) {
            if (offset < flower.begin) {
                break;
            }
            cur = Math.max(cur, flower.end);
        }
        return cur;
    }

    private void solve() {
        int cur = INCLUSIVE_BEGIN;
        while (cur < EXCLUSIVE_END) {
            int value = findMaxEndByComparingBeginBeforeCur(cur);
            if (cur != value) {
                cur = value;
                answer++;
            } else {
                break;
            }
        }
        sb.append(cur >= EXCLUSIVE_END ? answer : 0);
    }


    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static final class Flower implements Comparable<Flower> {
        public int begin;
        public int end;

        public Flower(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Flower flower) {
            if (this.begin == flower.begin) {
                return Integer.compare(flower.end, end);
            }
            return Integer.compare(begin, flower.begin);
        }
    }
}
