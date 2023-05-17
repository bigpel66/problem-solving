import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<String> list = IntStream.of(numbers).mapToObj(e -> String.valueOf(e)).collect(Collectors.toList());
        list.sort((v1, v2) -> (v2 + v1).compareTo(v1 + v2));
        list.forEach(e -> {
            sb.append(e);
        });
        String s = sb.toString();
        if (s.charAt(0) == '0') {
            return "0";
        } else {
            return s;
        }
    }
}