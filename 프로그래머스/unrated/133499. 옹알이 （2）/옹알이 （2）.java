import java.util.Arrays;
import java.util.List;

class Solution {
    
    static public final List<String> babblingWords = Arrays.asList("aya", "ye", "woo", "ma");

    
    public int solution(String[] babbling) {
          int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < babblingWords.size(); j++) {
                babbling[i] = babbling[i].replaceAll(babblingWords.get(j), String.valueOf(j));
            }
            boolean isIncrementable = true;
            for (int j = 0; j < babbling[i].length(); j++) {
                if (!Character.isDigit(babbling[i].charAt(j))) {
                    isIncrementable = false;
                }
                if (j + 1 < babbling[i].length() && babbling[i].charAt(j) == babbling[i].charAt(j + 1)) {
                    isIncrementable = false;
                }
            }
            if (isIncrementable) {
                answer++;
            }
        }
        return answer;
    }
}