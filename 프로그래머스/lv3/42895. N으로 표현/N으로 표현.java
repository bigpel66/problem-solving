import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static private final Integer maxDigit = 8;
    
    public int solution(int N, int number) {
        List<Set<Integer>> setList = generateSetList(N);
        for (int i = 2; i <= maxDigit; i++) {
            for (int j = 1; j < i; j++) {
                unionArithmetic(setList, i, j);
            }
        }
        for (int i = 1; i <= maxDigit; i++) {
            if (setList.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }

    public List<Set<Integer>> generateSetList(int n) {
        List<Set<Integer>> setList = new ArrayList<>() {{
            add(new HashSet<>());
        }};
        for (int i = 1; i <= maxDigit; i++) {
            setList.add(i, new HashSet<>());
            setList.get(i).add(Integer.valueOf(Integer.toString(n).repeat(i)));
        }
        return setList;
    }

    public void unionArithmetic(List<Set<Integer>> setList, int digit, int degree) {
        for (int i : setList.get(degree)) {
            for (int j : setList.get(digit - degree)) {
                setList.get(digit).add(i + j);
                setList.get(digit).add(i * j);
                setList.get(digit).add(i - j);
                setList.get(digit).add(j - i);
                if (i != 0) {
                    setList.get(digit).add(j / i);
                }
                if (j != 0) {
                    setList.get(digit).add(i / j);
                }
            }
        }
    }
}