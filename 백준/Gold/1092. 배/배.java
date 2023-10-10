import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private final StringBuilder sb;
    private int numberOfCrane, numberOfBox, day;
    private List<Integer> cranes, boxes;

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
        cranes = new ArrayList<>();
        boxes = new ArrayList<>();
        day = 0;
        numberOfCrane = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfCrane; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }
        numberOfBox = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfBox; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        cranes.sort(Comparator.reverseOrder());
        boxes.sort(Comparator.reverseOrder());
    }

    private void assignBoxesToEachCrane() {
        int craneIndex = 0, boxIndex = 0;
        while (craneIndex < cranes.size() && boxIndex < boxes.size()) {
            if (cranes.get(craneIndex) >= boxes.get(boxIndex)) {
                craneIndex++;
                boxes.remove(boxIndex);
            } else {
                boxIndex++;
            }
        }
    }

    private void solve() {
        if (boxes.get(0) > cranes.get(0)) {
            sb.append(-1);
            return;
        }
        while (!boxes.isEmpty()) {
            assignBoxesToEachCrane();
            day++;
        }
        sb.append(day);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}