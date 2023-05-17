import java.util.HashSet;
import java.util.Set;

class Solution {
    static private final Integer max = 10000000;

    static private final StringBuilder sb = new StringBuilder();

    static private final Set<Integer> combinedNumbers = new HashSet<>();

    static private final boolean[] isVisited = new boolean[8];

    static private final boolean[] isNotPrime = new boolean[max];
    
    public int solution(String numbers) {
        generatePrimeNumberMap();
        generateAllCombinations(numbers);
        int answer = 0;
        for (Integer integer : combinedNumbers) {
            if (!isNotPrime[integer]) {
                answer++;
            }
        }
        return answer;
    }

    public void generateAllCombinations(String digits) {
        for (int i = 0; i < digits.length(); i++) {
            findNDigitsCombination(digits, 0, i + 1);
        }
    }

    public void findNDigitsCombination(String digits, int curCount, int totalCount) {
        if (curCount == totalCount) {
            combinedNumbers.add(Integer.valueOf(sb.toString()));
            return;
        }
        for (int i = 0; i < digits.length(); i++) {
            if (!isVisited[i]) {
                sb.append(digits.charAt(i));
                isVisited[i] = true;
                findNDigitsCombination(digits, curCount + 1, totalCount);
                isVisited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public void generatePrimeNumberMap() {
        isNotPrime[0] = isNotPrime[1] = true;
        int sqrt = (int) Math.ceil(Math.sqrt(max));
        for (int i = 2; i <= sqrt; i++) {
            if (!isNotPrime[i]) {
                for (int j = i << 1; j < max; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}