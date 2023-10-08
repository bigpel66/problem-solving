import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private final StringBuilder sb;
    private int numberOfRoom;
    private List<Room> rooms = new ArrayList<>();
    private PriorityQueue<Integer> schedule = new PriorityQueue<>();

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
        numberOfRoom = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfRoom; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms.add(new Room(begin, end));
        }
        rooms.sort(Comparator.naturalOrder());
    }

    private void solve() {
        for (Room room : rooms) {
            if (!schedule.isEmpty() && room.begin >= schedule.peek()) {
                schedule.poll();
            }
            schedule.offer(room.end);
        }
        sb.append(schedule.size());
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