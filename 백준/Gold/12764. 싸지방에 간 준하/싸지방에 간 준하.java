import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int numberOfPeople, numberOfRoom;
    StringBuffer sb = new StringBuffer();
    int[] count;
    PriorityQueue<Person> people = new PriorityQueue<>();
    PriorityQueue<Room> rooms = new PriorityQueue<>();
    PriorityQueue<Integer> candidates = new PriorityQueue<>();

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        numberOfPeople = Integer.parseInt(br.readLine());
        numberOfRoom = 0;
        count = new int[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            people.add(new Person(begin, end));
        }
    }

    void solve() {
        for (int i = 0; i < numberOfPeople; i++) {
            Person cur = people.poll();
            if (cur == null) {
                return;
            }
            while (!rooms.isEmpty() && rooms.peek().end < cur.begin) {
                candidates.offer(rooms.poll().index);
            }
            int index = candidates.isEmpty() ? numberOfRoom++ : candidates.poll();
            count[index]++;
            rooms.offer(new Room(cur.end, index));
        }
        sb.append(numberOfRoom);
        sb.append('\n');
        for (int i = 0; i < numberOfPeople; i++) {
            if (count[i] != 0) {
                sb.append(count[i]);
                sb.append(' ');
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    static public class Person implements Comparable<Person> {

        public int begin;

        public int end;

        public Person(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Person o) {
            return begin - o.begin;
        }

    }

    static public class Room implements Comparable<Room> {

        public int end;

        public int index;

        public Room(int end, int index) {
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Room o) {
            return end - o.end;
        }

    }

}