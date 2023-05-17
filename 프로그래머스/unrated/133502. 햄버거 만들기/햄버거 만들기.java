import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < ingredient.length ; i++) {
            if (ingredient[i] == 1 && isStacked(list, i - answer * 4)) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                answer++;
            } else {
                list.add(ingredient[i]);
            }
        }
        return answer;
    }
    
    public boolean isStacked(List<Integer> list, int i) {
        if (list.size() < 3) {
            return false;
        }
        int order = 1;
        boolean isStacked = true;
        for (int j = i - 3 ; j >= 0 && j < i ; j++) {
            if (list.get(j) != order) {
                isStacked = false;
                break;
            }
            order++;
        }
        return isStacked;
    }
}