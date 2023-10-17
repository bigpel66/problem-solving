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
    private int numberOfTown, capacity, numberOfPackage;
    private int[] weightOnStep;
    private List<Parcel> parcels = new ArrayList<>();

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
        numberOfTown = Integer.parseInt(st.nextToken());
        capacity = Integer.parseInt(st.nextToken());
        numberOfPackage = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfPackage; i++) {
            st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            parcels.add(new Parcel(begin, end, weight));
        }
        parcels.sort(Comparator.naturalOrder());
        weightOnStep = new int[numberOfTown + 1];
    }

    private int findMaxWeightFromBeginToEnd(Parcel parcel) {
        int max = Integer.MIN_VALUE;
        for (int i = parcel.begin; i < parcel.end; i++) {
            max = Math.max(max, weightOnStep[i]);
        }
        return max;
    }

    private void updateMaxWeightFromBeginToEnd(Parcel parcel, int available) {
        for (int i = parcel.begin; i < parcel.end; i++) {
            weightOnStep[i] += available;
        }
    }

    private void solve() {
        int total = 0;
        for (int i = 0; i < numberOfPackage; i++) {
            Parcel current = parcels.get(i);
            int used = findMaxWeightFromBeginToEnd(current);
            int available = Math.min(capacity - used, current.weight);
            total += available;
            updateMaxWeightFromBeginToEnd(current, available);
        }
        total += weightOnStep[numberOfTown];
        sb.append(total);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static final class Parcel implements Comparable<Parcel> {
        public int begin;
        public int end;
        public int weight;

        public Parcel(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Parcel parcel) {
            if (end == parcel.end) {
                return Integer.compare(begin, parcel.begin);
            }
            return Integer.compare(end, parcel.end);
        }
    }
}