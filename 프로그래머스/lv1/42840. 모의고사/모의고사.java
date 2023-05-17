import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int person1Count = 0;
        int person2Count = 0;
        int person3Count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % 5]) {
                person1Count++;
            }
            if (answers[i] == person2[i % 8]) {
                person2Count++;
            }
            if (answers[i] == person3[i % 10]) {
                person3Count++;
            }
        }
        int max = person1Count > person2Count ? person1Count > person3Count ? person1Count : person3Count : person2Count > person3Count ? person2Count : person3Count;
        int finalPerson1Count = person1Count;
        int finalPerson2Count = person2Count;
        int finalPerson3Count = person3Count;
        List<Integer> list = new ArrayList<>() {{
            if (finalPerson1Count == max) {
                add(1);
            }
            if (finalPerson2Count == max) {
                add(2);
            }
            if (finalPerson3Count == max) {
                add(3);
            }
        }};
        return list.stream().mapToInt(e -> e).toArray();
    }
}