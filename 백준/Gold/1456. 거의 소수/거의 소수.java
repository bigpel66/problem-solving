import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private final StringBuilder sb;
    private long begin, end;
    private int limit;
    private boolean[] isNotPrime;
    private List<Long> nearPrime = new ArrayList<>();

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
        begin = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());
        limit = (int) Math.sqrt(end);
        isNotPrime = new boolean[limit + 1];
    }

    private void getPrime() {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 4; i <= limit; i += 2) {
            isNotPrime[i] = true;
        }
        for (int i = 3; i <= Math.sqrt(limit); i += 2) {
            for (int j = i * 3; j <= limit; j += i * 2) {
                isNotPrime[j] = true;
            }
        }
    }

    private void getNearPrime() {
        for (int i = 2; i <= limit; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = 2; ; j++) {
                long powered = (long) Math.pow(i, j);
                if (powered > end) {
                    break;
                }
                nearPrime.add(powered);
            }
        }
    }

    private <T extends Comparable<? super T>> int lowerBound(List<T> list, int left, int right, T value) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(value) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left < list.size() && list.get(left).compareTo(value) < 0) {
            left++;
        }
        return left;
    }

    private <T extends Comparable<? super T>> int upperBound(List<T> list, int left, int right, T value) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(value) <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left < list.size() && list.get(left).compareTo(value) <= 0) {
            left++;
        }
        return left;
    }

    private void solve() {
        getPrime();
        getNearPrime();
        nearPrime.sort(Comparator.naturalOrder());
        int lowerBoundIndex = lowerBound(nearPrime, 0, nearPrime.size() - 1, begin);
        int upperBoundIndex = upperBound(nearPrime, 0, nearPrime.size() - 1, end);
        sb.append(upperBoundIndex - lowerBoundIndex);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}