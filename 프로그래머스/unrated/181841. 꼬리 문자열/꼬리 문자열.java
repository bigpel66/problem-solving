class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < str_list.length ; i++) {
            if (str_list[i].contains(ex)) {
                continue;
            }
            sb.append(str_list[i]);
        }
        return sb.toString();
    }
}