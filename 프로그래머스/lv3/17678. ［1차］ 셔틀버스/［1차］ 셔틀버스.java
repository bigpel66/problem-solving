import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static public List<Integer> shuttlePlan;

    static public Map<Integer, Integer> shuttleCapacity;

    static public PriorityQueue<Integer> waitingLine;

    public String solution(int n, int t, int m, String[] timetable) {
        settingShuttles(n, t, m, timetable);
        int lastPersonTime = getLastPersonTime();
        int lastShuttleTime = shuttlePlan.get(shuttlePlan.size() - 1);
        if (shuttleCapacity.get(lastShuttleTime) > 0) {
            return String.format("%02d:%02d", lastShuttleTime / 60, lastShuttleTime % 60);
        } else {
            return String.format("%02d:%02d", lastPersonTime / 60, lastPersonTime % 60);
        }
    }

    public void settingShuttles(int n, int t, int m, String[] timetable) {
        List<Integer> integerTimeTable = Arrays.stream(timetable).map(e -> {
            String[] split = e.split(":");
            int waitingTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            return waitingTime;
        }).collect(Collectors.toList());
        shuttleCapacity = new HashMap<>();
        shuttlePlan = new ArrayList<>();
        waitingLine = new PriorityQueue<>(integerTimeTable);
        for (int i = 0; i < n; i++) {
            int time = 540 + i * t;
            shuttlePlan.add(time);
            shuttleCapacity.put(time, m);
        }
    }

    public int getLastPersonTime() {
        int lastPersonTime = 0;
        for (int i = 0; i < shuttlePlan.size(); i++) {
            int shuttleTime = shuttlePlan.get(i);
            int waitingTime = waitingLine.size();
            for (int j = 0; j < waitingTime; j++) {
                int capacity = shuttleCapacity.get(shuttleTime);
                int peek = waitingLine.peek();
                if (peek > shuttleTime || capacity <= 0) {
                    break;
                }
                if (capacity > 0) {
                    lastPersonTime = peek - 1;
                    shuttleCapacity.replace(shuttleTime, capacity - 1);
                    waitingLine.poll();
                }
            }
        }
        return lastPersonTime;
    }
}