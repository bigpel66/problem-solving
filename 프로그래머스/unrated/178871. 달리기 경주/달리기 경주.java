import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> rankMap = new HashMap<>();
        Map<String, Integer> playerMap = new HashMap<>();
        for (int i = 0 ; i < players.length ; i++) {
            rankMap.put(i, players[i]);
            playerMap.put(players[i], i);
        }
        for (int i = 0 ; i < callings.length ; i++) {
            int currentRank = playerMap.get(callings[i]);
            String formerPlayer = rankMap.get(currentRank - 1);
            playerMap.put(formerPlayer, currentRank);
            playerMap.put(callings[i], currentRank - 1);
            rankMap.put(currentRank, formerPlayer);
            rankMap.put(currentRank - 1, callings[i]);
        }
        String[] answer = new String[players.length];
        for (int i = 0 ; i < players.length ; i++) {
            answer[i] = rankMap.get(i);
        }
        return answer;
    }
}