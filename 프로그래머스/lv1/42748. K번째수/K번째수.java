import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            List<Integer> list = Arrays.stream(array).mapToObj(e -> e).collect(Collectors.toList());
            List<Integer> subList = list.subList(commands[i][0] - 1, commands[i][1]);
            subList.sort(Comparator.naturalOrder());
            answer.add(subList.get(commands[i][2] - 1));
        }
        return answer.stream().mapToInt(e -> e).toArray();
    }
}