import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        Set<Integer> answer = new HashSet<>();
        for (int i = 1 ; i < 1 << relation[0].length ; i++) {
            if (!isCandidate(i, answer)) {
                continue;
            }
            Set<String> set = new HashSet<>();
            for (int k = 0 ; k < relation.length ; k++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0 ; j < relation[0].length ; j++) {
                    if ((1 << j & i) == 0) {
                        continue;
                    }
                    sb.append(relation[k][j]);
                }
                if (!set.add(sb.toString())) {
                    break;
                }
            }
            if (set.size() == relation.length) {
                answer.add(i);
            }
        }
        return answer.size();
    }
    
    public boolean isCandidate(int value, Set<Integer> answer) {
        for (int i : answer) {
            if ((value & i) == i) {
                return false;
            }
        }
        return true;
    }
}