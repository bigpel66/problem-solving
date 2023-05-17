
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static public List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        List<String> list = new ArrayList<>();
        boolean[] isVisited = new boolean[tickets.length];
        dfs(list, tickets, isVisited, "ICN", 0);
        String[] returnArray = new String[answer.size()];
        return answer.toArray(returnArray);
    }

    public void dfs(List<String> list, String[][] tickets, boolean[] isVisited, String from, int count) {
        if (tickets.length == count) {
            list.add(from);
            if (isFormerMin(list, answer)) {
                answer.clear();
                answer.addAll(list);
            }
            list.remove(list.size() - 1);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!isVisited[i] && tickets[i][0].equals(from)) {
                isVisited[i] = true;
                list.add(tickets[i][0]);
                dfs(list, tickets, isVisited, tickets[i][1], count + 1);
                list.remove(list.size() - 1);
                isVisited[i] = false;
            }
        }
    }

    public boolean isFormerMin(List<String> a, List<String> b) {
        if (b.isEmpty()) {
            return true;
        }
        for (int i = 0; i < a.size(); i++) {
            int comparison = a.get(i).compareTo(b.get(i));
            if (comparison < 0) {
                return true;
            }
            if (comparison > 0) {
                return false;
            }
        }
        return false;
    }
}
