import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();
    int numberOfInformation, duration, penalty;
    Map<String, String> map = new HashMap<>();
    Map<String, Long> fin = new HashMap<>();
    List<String> answer;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    int getDuration(String s) {
        int v1 = s.charAt(0) - '0';
        int v2 = s.charAt(1) - '0';
        int v3 = s.charAt(3) - '0';
        int v4 = s.charAt(4) - '0';
        return (v1 * 10 + v2) * 60 + v3 * 10 + v4;
    }

    void getInput() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfInformation = Integer.parseInt(st.nextToken());
        String durationWithFormat = st.nextToken();
        String[] split = durationWithFormat.split("/");
        duration = Integer.parseInt(split[0]) * 24 * 60 + getDuration(split[1]);
        penalty = Integer.parseInt(st.nextToken());
    }

    void solve() throws Exception {
        for (int i = 0; i < numberOfInformation; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String stamp = st.nextToken() + " " + st.nextToken();
            String item = st.nextToken();
            String user = st.nextToken();
            String id = item + "_" + user;
            if (map.containsKey(id)) {
                String former = map.get(id);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                long diff = (format.parse(stamp).getTime() - format.parse(former).getTime()) / (60 * 1000);
                if (diff > duration) {
                    fin.put(user, fin.getOrDefault(user, 0L) + (diff - duration) * penalty);
                }
                map.remove(id);
            } else {
                map.put(id, stamp);
            }
        }
        if (fin.size() == 0) {
            sb.append("-1");
            return;
        }
        answer = new ArrayList<>(fin.keySet());
        answer.sort(Comparator.naturalOrder());
        for (String s : answer) {
            sb.append(s);
            sb.append(' ');
            sb.append(fin.get(s));
            sb.append('\n');
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}