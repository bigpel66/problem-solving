import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private final StringBuilder sb;
    private int numberOfHoney;
    private int[] honey;
    private long[] naturalAcc, reverseAcc;

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
        numberOfHoney = Integer.parseInt(br.readLine());
        honey = new int[numberOfHoney];
        naturalAcc = new long[numberOfHoney];
        reverseAcc = new long[numberOfHoney];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long temp = 0;
        for (int i = 0; i < numberOfHoney; i++) {
            int v = Integer.parseInt(st.nextToken());
            honey[i] = v;
            temp += v;
            naturalAcc[i] = temp;
        }
        temp = 0;
        for (int i = numberOfHoney - 1; i >= 0; i--) {
            temp += honey[i];
            reverseAcc[i] = temp;
        }
    }

    private long case1BeePot() {
        long localMax = 0;
        for (int i = 1; i < numberOfHoney - 1; i++) {
            long val1 = naturalAcc[numberOfHoney - 1] - naturalAcc[i];
            long val2 = naturalAcc[numberOfHoney - 1] - naturalAcc[0] - honey[i];
            localMax = Math.max(val1 + val2, localMax);
        }
        return localMax;
    }

    private long case2PotBee() {
        long localMax = 0;
        for (int i = 1; i < numberOfHoney - 1; i++) {
            long val1 = reverseAcc[0] - reverseAcc[i];
            long val2 = reverseAcc[0] - reverseAcc[numberOfHoney - 1] - honey[i];
            localMax = Math.max(val1 + val2, localMax);
        }
        return localMax;
    }

    private long case3BeeBee() {
        long localMax = 0;
        for (int i = 1; i < numberOfHoney - 1; i++) {
            long val1 = naturalAcc[i] - honey[0];
            long val2 = reverseAcc[i] - honey[numberOfHoney - 1];
            localMax = Math.max(val1 + val2, localMax);
        }
        return localMax;
    }

    private <E extends Comparable<? super E>> E max(List<? extends E> list) {
        E e = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (e.compareTo(list.get(i)) < 0) {
                e = list.get(i);
            }
        }
        return e;
    }

    private void solve() {
        sb.append(max(List.of(case1BeePot(), case2PotBee(), case3BeeBee())));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}