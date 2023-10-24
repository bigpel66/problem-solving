import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class Main {
    private final StringBuilder sb;
    private int numberOfDay;
    private long money;
    private List<Integer> unitPrices = new ArrayList<>();

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
        numberOfDay = Integer.parseInt(st.nextToken());
        money = Long.parseLong(st.nextToken());
        for (int i = 0; i < numberOfDay; i++) {
            int unitPrice = Integer.parseInt(br.readLine());
            unitPrices.add(unitPrice);
        }
    }

    private void increaseAsset(int init, int curr) {
        if (init == curr) {
            return;
        }
        long amount = money / init;
        money += (curr * amount - init * amount);
    }

    private void solve() {
        int init, curr;
        init = curr = unitPrices.get(0);
        for (int i = 1; i < numberOfDay; i++) {
            if (curr >= unitPrices.get(i)) {
                increaseAsset(init, curr);
                init = unitPrices.get(i);
            }
            curr = unitPrices.get(i);
        }
        increaseAsset(init, curr);
        sb.append(money);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}