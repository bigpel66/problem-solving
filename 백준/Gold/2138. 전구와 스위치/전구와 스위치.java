import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfBulb;
    private Bulb a, b, expected;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        numberOfBulb = Integer.parseInt(br.readLine());
        String l1 = br.readLine();
        String l2 = br.readLine();
        a = new Bulb(l1);
        b = new Bulb(l1);
        expected = new Bulb(l2);
        a.toggle(0);
    }

    private void branchAnswer() {
        boolean aMatched = a.equals(expected);
        boolean bMatched = b.equals(expected);
        if (aMatched && bMatched) {
            sb.append(Math.min(a.switchCount, b.switchCount));
        } else if (aMatched) {
            sb.append(a.switchCount);
        } else if (bMatched) {
            sb.append(b.switchCount);
        } else {
            sb.append(-1);
        }
    }

    private void solve() {
        for (int i = 1; i < numberOfBulb; i++) {
            a.makeFit(expected, i);
            b.makeFit(expected, i);
        }
        branchAnswer();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    private static class Bulb {
        public List<Boolean> state;
        public int switchCount;

        public Bulb(String data) {
            toState(data);
            switchCount = 0;
        }

        private void toState(String data) {
            if (state == null) {
                state = new ArrayList<>();
            }
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == '0') {
                    state.add(false);
                } else if (data.charAt(i) == '1') {
                    state.add(true);
                }
            }
        }

        public void toggle(int index) {
            state.set(index, !state.get(index));
            if (index == 0) {
                state.set(index + 1, !state.get(index + 1));
            } else if (index == state.size() - 1) {
                state.set(index - 1, !state.get(index - 1));
            } else {
                state.set(index - 1, !state.get(index - 1));
                state.set(index + 1, !state.get(index + 1));
            }
            switchCount++;
        }

        public void makeFit(Bulb bulb, int index) {
            boolean current = state.get(index - 1);
            boolean expected = bulb.state.get(index - 1);
            if (current != expected) {
                toggle(index);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Bulb)) {
                return false;
            }
            Bulb b = (Bulb) o;
            return b.state.equals(this.state);
        }

        @Override
        public int hashCode() {
            return Objects.hash(state);
        }
    }
}