import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>(Arrays.stream(lost).boxed().collect(Collectors.toList()));
        Set<Integer> reserveSet = new HashSet<>(Arrays.stream(reserve).boxed().collect(Collectors.toList()));
        Set<Integer> intersection = new HashSet<>(lostSet);
        intersection.retainAll(reserveSet);
        lostSet.removeAll(intersection);
        reserveSet.removeAll(intersection);
        for (Integer i : lostSet) {
            Integer former = i - 1;
            Integer latter = i + 1;
            if (reserveSet.contains(former)) {
                reserveSet.remove(former);
            } else if (reserveSet.contains(latter)) {
                reserveSet.remove(latter);
            } else {
                n--;
            }
        }
        return n;
    }
}