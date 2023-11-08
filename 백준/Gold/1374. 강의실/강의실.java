import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfRoom, max;
    private final List<Room> rooms = new ArrayList<>();
    private final PriorityQueue<Room> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.end));

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
        max = 0;
        for (int i = 0; i < numberOfRoom; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms.add(new Room(index, begin, end));
        }
        rooms.sort(Comparator.naturalOrder());
    }

    private void solve() {
        for (int i = 0; i < numberOfRoom; i++) {
            while (!pq.isEmpty() && pq.peek().end <= rooms.get(i).begin) {
                pq.poll();
            }
            pq.offer(rooms.get(i));
            max = Math.max(max, pq.size());
        }
        sb.append(max);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static class Room implements Comparable<Room> {
        public int index;
        public int begin;
        public int end;

        public Room(int index, int begin, int end) {
            this.index = index;
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