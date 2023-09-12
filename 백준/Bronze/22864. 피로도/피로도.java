import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private final StringBuffer sb;
    private int stressPerHour, throughputPerHour, relievePerHour, stressLimit;
    private int currentStress, availability;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuffer();
            getInput(br);
            solve(br);
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        stressPerHour = Integer.parseInt(st.nextToken());
        throughputPerHour = Integer.parseInt(st.nextToken());
        relievePerHour = Integer.parseInt(st.nextToken());
        stressLimit = Integer.parseInt(st.nextToken());
        currentStress = availability = 0;
    }

    private void solve(BufferedReader br) throws Exception {
        for (int i = 0; i < 24; i++) {
            if (currentStress + stressPerHour <= stressLimit) {
                availability += throughputPerHour;
                currentStress += stressPerHour;
            } else {
                currentStress -= Math.min(currentStress, relievePerHour);
            }
        }
        sb.append(availability);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}