import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        Set<Character> elements = new HashSet<>();
        for (int i = 0 ; i < spell.length ; i++) {
            elements.add(spell[i].charAt(0));
        }
        for (int i = 0 ; i < dic.length ; i++) {
            Set<Character> compare = new HashSet<>();
            for (int j = 0 ; j < dic[i].length() ; j++) {
                compare.add(dic[i].charAt(j));
            }
            if (elements.equals(compare)) {
                return 1;
            }
        }
        return 2;
    }
}