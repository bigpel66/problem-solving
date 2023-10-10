import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private final StringBuilder sb;
    private int numberOfSensor, numberOfBase;
    private int[] range, diff;

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
        numberOfSensor = Integer.parseInt(br.readLine());
        numberOfBase = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        range = new int[numberOfSensor];
        diff = new int[numberOfSensor - 1];
        for (int i = 0; i < numberOfSensor; i++) {
            range[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(range);
        for (int i = 1; i < numberOfSensor; i++) {
            diff[i - 1] = range[i] - range[i - 1];
        }
        Arrays.sort(diff);
    }

    private void solve() {
        int answer = 0;
        for (int i = 0; i < numberOfSensor - numberOfBase; i++) {
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