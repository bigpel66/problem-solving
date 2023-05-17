import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> blocked = new HashSet<>();
        Map<String, Set<String>> reportedMap = new HashMap<>();
        Map<String, Set<String>> collectedMap = new HashMap<>();
        for (int i = 0 ; i < id_list.length ; i++) {
            reportedMap.put(id_list[i], new HashSet<>());
            collectedMap.put(id_list[i], new HashSet<>());
        }
        for (int i = 0 ; i < report.length ; i++) {
            String[] split = report[i].split(" ");
            String source = split[0];
            String target = split[1];
            Set<String> sourceReportedMap = reportedMap.get(source);
            sourceReportedMap.add(target);
            Set<String> targetCollectedMap = collectedMap.get(target);
            targetCollectedMap.add(source);
            reportedMap.put(source, sourceReportedMap);
            collectedMap.put(target, targetCollectedMap);
        }
        for (Map.Entry<String, Set<String>> entry : collectedMap.entrySet()) {
            if (entry.getValue().size() >= k) {
                blocked.add(entry.getKey());
            }
        }
        int[] answer = new int[id_list.length];
        for (int i = 0 ; i < id_list.length ; i++) {
            Set<String> set =  reportedMap.get(id_list[i]);
            set.retainAll(blocked);
            answer[i] = set.size();
        }
        return answer;
    }
}