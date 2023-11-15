import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfDigit, budget;
    private final List<Number> numbers = new ArrayList<>();
    private final Map<Integer, Integer> numberMap = new HashMap<>();

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
        numberOfDigit = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfDigit; i++) {
            int price = Integer.parseInt(st.nextToken());
            numbers.add(new Number(i, price));
            numberMap.put(i, price);
        }
        budget = Integer.parseInt(br.readLine());
        numbers.sort(Comparator.naturalOrder());
    }

    private boolean isPrimaryMinimumCostZero() {
        return numbers.get(0).digit == 0;
    }

    private boolean isOnlyZeroAvailable() {
        return numberOfDigit == 1;
    }

    private boolean isSecondaryMinimumOutOfBudget() {
        return numbers.get(1).price > budget;
    }

    private boolean isAnswerZero() {
        return (isPrimaryMinimumCostZero()) &&
                (isOnlyZeroAvailable() || isSecondaryMinimumOutOfBudget());
    }

    private void appendPrimaryMinimumAndSpend() {
        sb.append(numbers.get(0).digit);
        budget -= numbers.get(0).price;
    }

    private void appendSecondaryMinimumAndSpend() {
        sb.append(numbers.get(1).digit);
        budget -= numbers.get(1).price;
    }

    private int getExchangeBudget(int previousValue, int exchangeValue) {
        return budget + previousValue - exchangeValue;
    }

    private void exchangeDigit(int offset) {
        for (int i = numberOfDigit - 1; i >= 0; i--) {
            if (offset == 0 && i == 0) {
                return;
            }
            int candidate = getExchangeBudget(numberMap.get(sb.charAt(offset) - '0'), numberMap.get(i));
            if (candidate >= 0) {
                budget = candidate;
                sb.setCharAt(offset, (char) (i + '0'));
                break;
            }
        }
    }

    private void solve() {
        if (isAnswerZero()) {
            sb.append(0);
            return;
        }
        if (isPrimaryMinimumCostZero()) {
            appendSecondaryMinimumAndSpend();
        }
        while (numbers.get(0).price <= budget) {
            appendPrimaryMinimumAndSpend();
        }
        for (int i = 0; i < sb.length(); i++) {
            exchangeDigit(i);
        }
    }


    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static final class Number implements Comparable<Number> {
        public int digit;
        public int price;

        public Number(int digit, int price) {
            this.digit = digit;
            this.price = price;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(price, o.price);
        }
    }
}
