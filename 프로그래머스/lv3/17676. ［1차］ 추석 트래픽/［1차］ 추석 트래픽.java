import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static public class Timestamp {

        public int value;

        public boolean isBegin;

        public Timestamp(int value, boolean isBegin) {
            this.value = value;
            this.isBegin = isBegin;
        }

    }

    public int solution(String[] lines) {
        List<Timestamp> timestamps = generateTimestamp(lines);
        timestamps.sort((v1, v2) -> v1.value <= v2.value ? -1 : 1);
        return getThroughput(timestamps);
    }

    static List<Timestamp> generateTimestamp(String[] lines) {
        List<Timestamp> timestamps = new ArrayList<>();
        Arrays.stream(lines).forEach(e -> {
            String timestamp = e.substring(11);
            String[] integerAndDouble = timestamp.split(":");
            int hourToMs = Integer.parseInt(integerAndDouble[0]) * 3600 * 1000;
            int minToMs = Integer.parseInt(integerAndDouble[1]) * 60 * 1000;
            String[] doubleAndDuration = integerAndDouble[2].split(" ");
            int secondToMs = (int) (Double.parseDouble(doubleAndDuration[0]) * 1000);
            int durationToMs = (int) (Double.parseDouble(doubleAndDuration[1].substring(0, doubleAndDuration[1].length() - 1)) * 1000);
            int end = hourToMs + minToMs + secondToMs;
            Timestamp begin = new Timestamp(end - durationToMs + 1, true);
            Timestamp expired = new Timestamp(end + 999, false);
            timestamps.addAll(Arrays.asList(begin, expired));
        });
        return timestamps;
    }

    public int getThroughput(List<Timestamp> timestamps) {
        int answer = 0;
        int count = 0;
        for (int i = 0; i < timestamps.size(); i++) {
            if (timestamps.get(i).isBegin) {
                count++;
            } else {
                count--;
            }
            answer = Math.max(count, answer);
        }
        return answer;
    }
}