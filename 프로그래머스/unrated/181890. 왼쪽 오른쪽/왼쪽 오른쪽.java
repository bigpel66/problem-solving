import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        Boolean direction = null;
        int index = -1;
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < str_list.length ; i++) {
            boolean isLeft = str_list[i].equals("l");
            boolean isRight = str_list[i].equals("r");
            if (!isLeft && !isRight) {
                list.add(str_list[i]);
            } else {
                index = i;
                direction = isLeft ? true : false;
                break;
            }
        }
        if (direction == null) {
            return new String[0];
        } else if (direction) {
            return list.stream().toArray(String[]::new);
        } else {
            list.clear();
            for (int i = index + 1 ; i < str_list.length ; i++) {
                list.add(str_list[i]);
            }
            return list.stream().toArray(String[]::new);
        }
    }
}