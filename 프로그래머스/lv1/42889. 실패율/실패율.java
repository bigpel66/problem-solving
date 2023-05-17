import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Map.Entry<Double, Integer>> list = new ArrayList<>();
        for (int i = 1 ; i <= N; i++) {
            int denominator = 0;
            int numerator = 0;
            for (int j = 0 ; j < stages.length ; j++) {
                if (stages[j] >= i) {
                    if (stages[j] == i) {
                        numerator++;
                    }
                    denominator++;
                }
            }
            double rate = 0.0;
            if (denominator != 0) {
                rate = (double) numerator / denominator;
            }
            list.add(Map.entry(rate, i));
        }
        return list.stream().sorted((v1, v2) -> Integer.compare(v1.getValue(), v2.getValue())).sorted((v1, v2) -> Double.compare(v2.getKey(), v1.getKey())).mapToInt(e-> e.getValue()).toArray();
    }
}