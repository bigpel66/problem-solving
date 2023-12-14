import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class Main {
    private final StringBuilder sb;

    public Main() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void solve() throws Exception {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        sb.append(zonedDateTime.getYear()).append("\n");
        sb.append(zonedDateTime.getMonthValue()).append("\n");
        sb.append(zonedDateTime.getDayOfMonth()).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
