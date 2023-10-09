import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private final StringBuilder sb;
    private int numberOfChild, numberOfGroup;
    private int[] height, diff;

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
        numberOfChild = Integer.parseInt(st.nextToken());
        numberOfGroup = Integer.parseInt(st.nextToken());
        height = new int[numberOfChild];
        diff = new int[numberOfChild - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfChild; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            if (i != 0) {
                diff[i - 1] = height[i] - height[i - 1];
            }
        }
        Arrays.sort(diff);
    }

    private void solve() {
        int answer = 0;
        for (int i = 0; i < numberOfChild - numberOfGroup; i++) {
            answer += diff[i];
        }
        sb.append(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static class Room implements Comparable<Room> {
        public int begin;
        public int end;

        public Room(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Room room) {
            if (begin == room.begin) {
                return Integer.compare(end, room.end);
            }
            return Integer.compare(begin, room.begin);
        }
    }

}